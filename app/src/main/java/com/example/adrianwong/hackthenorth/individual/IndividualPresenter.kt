package com.example.adrianwong.hackthenorth.individual

import android.util.Log
import com.example.adrianwong.hackthenorth.repository.RepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class IndividualPresenter(private val repo: RepositoryImpl) : IndividualContract.Presenter {
    private lateinit var individualView: IndividualContract.View
    private val disposables = CompositeDisposable()

    override fun attachView(view: IndividualContract.View) {
        individualView = view
    }

    override fun onSubmitIndividualDonation(uuid: String, recieverId: String, moneyAmount: Int) {
        disposables.add(repo.donateToIndividual(uuid, recieverId, moneyAmount)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ result ->
                Log.d("yeet", "result: ${result.result}")
                individualView.hideSpinner()
                individualView.makeToast("success")
            }, {
                individualView.makeToast("fail")
                Log.d("henlo", it.localizedMessage)
            }))
    }

    fun detachView() {
        disposables.dispose()
    }
}
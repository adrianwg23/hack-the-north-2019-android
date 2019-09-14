package com.example.adrianwong.hackthenorth.pool

import android.util.Log
import com.example.adrianwong.hackthenorth.repository.PoolRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PoolPresenter(private val poolRepository: PoolRepositoryImpl) : PoolContract.Presenter {

    private lateinit var poolView: PoolContract.View
    private val disposables = CompositeDisposable()

    override fun attachView(view: PoolContract.View) {
        poolView = view
    }

    override fun submitDonation() {
        disposables.add(poolRepository.pingFunction()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ result ->
                Log.d("henlo", "success")
                poolView.makeToast(result.result)
            }, {
                poolView.makeToast("fail")
                Log.d("henlo", it.localizedMessage)
            }))
    }
}
package com.example.adrianwong.hackthenorth.individual

import com.example.adrianwong.hackthenorth.dashboard.DashboardContract
import com.example.adrianwong.hackthenorth.repository.RepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class IndividualPresenter(private val repo: RepositoryImpl) : IndividualContract.Presenter {
    private lateinit var individualPresenter: IndividualContract.View
    private val disposables = CompositeDisposable()

    override fun attachView(view: IndividualContract.View) {
        individualPresenter = view
    }

    override fun onSubmitIndividualDonation() {
        //make api call
    }
}
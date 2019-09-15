package com.example.adrianwong.hackthenorth.dashboard

import android.util.Log
import com.example.adrianwong.hackthenorth.pool.PoolContract
import com.example.adrianwong.hackthenorth.repository.RepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DashboardPresenter(private val repo: RepositoryImpl) : DashboardContract.Presenter {
    private lateinit var dashboardView: DashboardContract.View
    private val disposables = CompositeDisposable()

    override fun attachView(view: DashboardContract.View) {
        dashboardView = view

        disposables.add(
            repo.getCurrentPoolFunction()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    Log.d("henlo", "success")
                    view.showCurrentPool(result.totalAmount.toString(), result.date)
                }, {
                    Log.d("henlo", it.localizedMessage)
                })
        )
        
    }

}
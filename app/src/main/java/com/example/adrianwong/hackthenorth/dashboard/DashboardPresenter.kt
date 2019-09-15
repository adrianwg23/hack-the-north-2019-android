package com.example.adrianwong.hackthenorth.dashboard

import android.util.Log
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
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
                    view.updateCurrentPool(result.totalAmount)
                }, {
                    Log.d("henlo", it.localizedMessage)
                })
        )

    }

    override fun getHistoryList(): ArrayList<CurrentPool> {
        var list = ArrayList<CurrentPool>()
        disposables.add(
            repo.getAllPoolFunction()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    Log.d("henlo", "success")
                    list = result.arrayList
                }, {
                    Log.d("henlo", it.localizedMessage)
                })
        )
        
        return list
    }

    fun detachView() {
        disposables.dispose()
    }

}
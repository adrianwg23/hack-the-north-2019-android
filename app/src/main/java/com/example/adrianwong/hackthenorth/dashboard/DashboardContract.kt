package com.example.adrianwong.hackthenorth.dashboard

import com.example.adrianwong.hackthenorth.datamodels.CurrentPool

interface DashboardContract {

    interface View {
        fun showCurrentPool(currentPool: String, date: String)
        fun updateCurrentPool(currentPool: Int)
        fun updateCurrentPoolList(currentPoolList: List<CurrentPool>)
    }

    interface Presenter {
        fun attachView(view: View)
        
    }
}
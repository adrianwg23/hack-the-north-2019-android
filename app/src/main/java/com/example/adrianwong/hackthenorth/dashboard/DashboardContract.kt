package com.example.adrianwong.hackthenorth.dashboard

import com.example.adrianwong.hackthenorth.datamodels.CurrentPool

interface DashboardContract {

    interface View {
        fun showCurrentPool(currentPool: String, date: String)
        fun updateCurrentPool(currentPool: Int)
    }

    interface Presenter {
        fun attachView(view: View)
        
        fun getHistoryList() : ArrayList<CurrentPool>
    }
}
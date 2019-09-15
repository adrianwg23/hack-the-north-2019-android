package com.example.adrianwong.hackthenorth.dashboard

interface DashboardContract {

    interface View {
        fun showCurrentPool(currentPool: String, date: String)
        fun updateCurrentPool(currentPool: Int)
    }

    interface Presenter {
        fun attachView(view: View)

    }
}
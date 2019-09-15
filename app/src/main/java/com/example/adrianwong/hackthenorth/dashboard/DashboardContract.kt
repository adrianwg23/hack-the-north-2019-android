package com.example.adrianwong.hackthenorth.dashboard

interface DashboardContract {

    interface View {
        fun showCurrentPool(currentPool: String, date: String)
    }

    interface Presenter {
        fun attachView(view: View)

    }
}
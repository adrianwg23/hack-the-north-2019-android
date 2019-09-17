package com.example.adrianwong.hackthenorth.dashboard

import com.example.adrianwong.hackthenorth.datamodels.DonationsInfo

interface DashboardContract {

    interface View {
        fun showCurrentPool(currentPool: String, date: String)
        fun updateCurrentPool(currentPool: Int)
        fun updateCurrentDonorInfo(donationsInfo: List<DonationsInfo>?)
    }

    interface Presenter {
        fun attachView(view: View)
        
    }
}
package com.example.adrianwong.hackthenorth.pool

interface PoolContract {

    interface View {
        fun showSuccessfulDonation()

        fun donationError()

        fun makeToast(value: String)

        fun hideSpinner()

    }

    interface Presenter {
        fun attachView(view: View)

        fun submitDonation(donorId: String, amount: Int)

        fun detachView()
    }
}
package com.example.adrianwong.hackthenorth.pool

interface PoolContract {

    interface View {
        fun showSuccessfulDonation()

        fun donationError()

        fun makeToast(value: String)

    }

    interface Presenter {
        fun attachView(view: View)

        fun submitDonation()
    }
}
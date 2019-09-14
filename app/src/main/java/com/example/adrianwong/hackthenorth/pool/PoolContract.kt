package com.example.adrianwong.hackthenorth.pool

interface PoolContract {

    interface View {
        fun showSuccessfulDonation()

        fun donationError()

    }

    interface Presenter {
        fun onAttach()

        fun submitDonation()
    }
}
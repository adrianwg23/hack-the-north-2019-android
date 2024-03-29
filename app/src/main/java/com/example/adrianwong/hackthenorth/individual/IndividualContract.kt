package com.example.adrianwong.hackthenorth.individual

interface IndividualContract {

    interface View {
        fun makeToast(value: String)

        fun hideSpinner()
    }

    interface Presenter {
        fun attachView(view: View)
        
        fun onSubmitIndividualDonation(uuid: String, recieverId: String, moneyAmount: Int)
    }
}
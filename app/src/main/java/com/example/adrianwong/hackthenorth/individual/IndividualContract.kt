package com.example.adrianwong.hackthenorth.individual

interface IndividualContract {

    interface View {
        
    }

    interface Presenter {
        fun attachView(view: View)
        
        fun onSubmitIndividualDonation()
    }
}
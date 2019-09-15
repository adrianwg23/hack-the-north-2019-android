package com.example.adrianwong.hackthenorth.individual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adrianwong.hackthenorth.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class IndividualPayBottomSheet : BottomSheetDialogFragment() {
    var onSubmitMoney: ((amount: Int) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        submit_money.setOnClickListener() {
            onSubmitMoney?.invoke(enter_money.text.toString().toInt())
        }


        return super.onCreateView(inflater, container, savedInstanceState)
    }
}

package com.example.adrianwong.hackthenorth.individual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.adrianwong.hackthenorth.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class IndividualPayBottomSheet : BottomSheetDialogFragment() {

    private lateinit var subitMoneyTv: TextView
    private lateinit var enterMoneyEt: EditText
    private lateinit var closeModal: ImageView
    var onSubmitMoney: ((amount: Int) -> Unit)? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        enterMoneyEt = view.findViewById(R.id.enter_money)
        subitMoneyTv = view.findViewById(R.id.submit_money)
        closeModal = view.findViewById(R.id.close_modal)
        subitMoneyTv.setOnClickListener { onSubmitMoney?.invoke(enterMoneyEt.text.toString().toInt()) }
        closeModal.setOnClickListener{
            dismiss()
        }
        return view
    }
}

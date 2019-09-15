package com.example.adrianwong.hackthenorth.individual

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adrianwong.hackthenorth.R
import kotlinx.android.synthetic.main.fragment_individual.*
import com.example.adrianwong.hackthenorth.BarCodeScannerActivity
import com.example.adrianwong.hackthenorth.MainApplication
import com.example.adrianwong.hackthenorth.pool.PoolPresenter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_pool.*
import javax.inject.Inject


class IndividualFragment : Fragment() {
    companion object {
        const val REQUEST_CODE = 9999
    }

    @Inject
    lateinit var presenter: IndividualPresenter
    private var currentState = 0
    private var moneyAmount: Int = 0
    private var recieverId = ""

    var individualPayBottomSheet = IndividualPayBottomSheet()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.application as MainApplication).createIndividualSubcomponent().inject(this)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_individual, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        openScanner.setOnClickListener {
            val intent = Intent(activity, BarCodeScannerActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        individualPayBottomSheet.onSubmitMoney = {
            if (moneyValue.text == null && moneyValue.text.toString().equals("")) {
                Snackbar.make(
                    container, "Please enter a real amount of money to donate",
                    Snackbar.LENGTH_SHORT
                )
            } else {
                val UUID = (activity!!.application as MainApplication).UUID
                Log.d("PoolFragTag", "uuid: $UUID")
                presenter.onSubmitIndividualDonation(UUID, recieverId, moneyAmount)
            }
        }
        
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("result")
                result?.let {
                    if (it != "") {
                        Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
                        individualPayBottomSheet.isCancelable = false
                        individualPayBottomSheet.show(fragmentManager!!, "")

                    }
                }
            } else {
                Toast.makeText(activity, "Please try again", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        (activity?.application as MainApplication).releaseIndividualSubcomponent()
        super.onDestroyView()
    }

}

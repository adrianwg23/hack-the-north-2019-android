package com.example.adrianwong.hackthenorth.individual

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adrianwong.hackthenorth.BarCodeScannerActivity
import com.example.adrianwong.hackthenorth.MainApplication
import com.example.adrianwong.hackthenorth.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_individual.*
import javax.inject.Inject


class IndividualFragment : Fragment(), IndividualContract.View {

    companion object {
        const val REQUEST_CODE = 9999
    }

    @Inject lateinit var presenter: IndividualPresenter

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
        presenter.attachView(this)
        openScanner.setOnClickListener {
            val intent = Intent(activity, BarCodeScannerActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val receiverUUID = data?.getStringExtra("result")
                receiverUUID?.let {
                    if (it != "") {
                        Log.d("IndividualFragTag", it)
                        receiverUUID.trim()
                        individualPayBottomSheet.onSubmitMoney = {
                            if (it == 0) {
                                Snackbar.make(
                                    container, "Please enter a real amount of money to donate",
                                    Snackbar.LENGTH_SHORT
                                )
                            } else {
                                val donatorUUID = (activity!!.application as MainApplication).UUID
                                Log.d("IndividualFragTag", "uuid: $donatorUUID, receiverId: $receiverUUID, amount: $it")
                                presenter.onSubmitIndividualDonation(donatorUUID, receiverUUID, it)
                                individualPayBottomSheet.dismiss()
                            }
                        }
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
        presenter.detachView()
        super.onDestroyView()
    }

    override fun makeToast(value: String) {
        Toast.makeText(activity, value, Toast.LENGTH_LONG).show()
    }

}

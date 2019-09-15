package com.example.adrianwong.hackthenorth.individual

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        const val EXTRA_UUID: String = "uuid"
        const val EXTRA_LAYOUT_COUNTER: String = "layout"
    }

    @Inject
    lateinit var presenter: IndividualPresenter
    private var currentState = 0
    private var moneyAmount: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.application as MainApplication).createIndividualSubcomponent().inject(this)
        // Inflate the layout for this fragment
        if (arguments?.getBoolean(EXTRA_LAYOUT_COUNTER) == true) {
            currentState = 1
            return inflater.inflate(R.layout.fragment_pool, container, false)
        }
        return inflater.inflate(R.layout.fragment_individual, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (currentState == 0) {
            openScanner.setOnClickListener {
                val intent = Intent(activity, BarCodeScannerActivity::class.java)
                activity?.startActivity(intent)
            }
        } else {
            counterLogic()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        (activity?.application as MainApplication).releaseIndividualSubcomponent()
        super.onDestroyView()
    }

    private fun counterLogic() {
        moneyValue.setText(moneyAmount.toString())

        plusMoneyValue.setOnClickListener {
            moneyAmount++
            moneyValue?.setText(moneyAmount.toString())
        }

        minusMoneyValue.setOnClickListener {
            if (moneyAmount > 0) {
                moneyAmount--
                moneyValue.setText(moneyAmount.toString())
            }
        }

        moneyValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (moneyValue.text.toString() == "") moneyAmount = 0
                else moneyAmount = moneyValue.text.toString().toInt()
            }
        })

        submitDonation.setOnClickListener {
            if (moneyValue.text == null && moneyValue.text.toString().equals("")) {
                Snackbar.make(container, "Please enter a real amount of money to donate",
                    Snackbar.LENGTH_SHORT)
            } else {
                presenter.onSubmitIndividualDonation()
            }
        }
    }

}

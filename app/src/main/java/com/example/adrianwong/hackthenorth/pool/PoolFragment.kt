package com.example.adrianwong.hackthenorth.pool


import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adrianwong.hackthenorth.MainApplication
import com.example.adrianwong.hackthenorth.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_pool.*
import javax.inject.Inject


class PoolFragment : Fragment(), PoolContract.View {

    @Inject lateinit var presenter: PoolPresenter
    private var moneyAmount: Int = 0


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (activity?.application as MainApplication).createPoolSubcomponent().inject(this)
        // Inflate the layout for this fragments
        return inflater.inflate(R.layout.fragment_pool, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.attachView(this)
        setupViews()
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroyView() {
        (activity?.application as MainApplication).releasePoolSubcomponent()
        presenter.detachView()
        super.onDestroyView()
    }

    override fun showSuccessfulDonation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun donationError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setupViews() {
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
                val UUID = (activity!!.application as MainApplication).UUID
                Log.d("PoolFragTag", "uuid: $UUID")
                presenter.submitDonation(UUID, moneyAmount)
            }
        }
    }

    override fun makeToast(value: String) {
        Toast.makeText(this.context, value, Toast.LENGTH_LONG).show()
    }

    fun showCreateCategoryDialog() {

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Payment Transaction")

        val view = layoutInflater.inflate(R.layout.fragment_modal_success, null)
        builder.setView(view)

        builder.setPositiveButton(android.R.string.ok) { dialog, _ ->
            dialog.dismiss()

        }
        builder.show()
    }

}

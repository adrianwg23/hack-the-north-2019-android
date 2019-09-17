package com.example.adrianwong.hackthenorth

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adrianwong.hackthenorth.repository.RepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_atm.*
import kotlinx.android.synthetic.main.activity_merchant.*
import javax.inject.Inject

class MerchantActivity : AppCompatActivity() {

    companion object{
        const val MERCHANT_BARCODE_RESULT : Int = 8
    }

    @Inject lateinit var repositoryImpl: RepositoryImpl

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_merchant)

        (application as MainApplication).mainComponent.inject(this)

        scanning_to_charge.setOnClickListener {
            val intent = Intent(this, BarCodeScannerActivity::class.java)
            startActivityForResult(intent, MERCHANT_BARCODE_RESULT)
            //Todo: get barcode uuid, package it along with the value of the item purchased (eg: -5)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == MerchantActivity.MERCHANT_BARCODE_RESULT) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("result")
                result?.let {
                    if (it != "") {
                        progress_bar_merchant.visibility = View.VISIBLE
                        disposables.add(repositoryImpl.merchantMinus(it.trim(), editbox.text.toString().toInt())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe { result ->
                                Toast.makeText(this, "Successful transaction.", Toast.LENGTH_LONG).show()
                                progress_bar_merchant.visibility = View.GONE
                            })
                    }
                }
            } else {
                Toast.makeText(this, "Please try again", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun alert(){
        val builder = AlertDialog.Builder(this@MerchantActivity)

        // Set the alert dialog title
        builder.setTitle("Welcome to the Balance Checker")

        // Display a message on alert dialog
        builder.setMessage("Here is your current balance " )

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("Okay thanks."){dialog, which ->
            dialog.dismiss()
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }

}
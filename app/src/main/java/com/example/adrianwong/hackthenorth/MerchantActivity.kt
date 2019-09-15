package com.example.adrianwong.hackthenorth

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_merchant.*

class MerchantActivity : AppCompatActivity() {

    companion object{
        const val MERCHANT_BARCODE_RESULT : Int = 8
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_merchant)

        scanning_to_charge.setOnClickListener {
            val intent = Intent(this, BarCodeScannerActivity::class.java)
            startActivity(intent)
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
                        //make network request... with uuid and money update
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
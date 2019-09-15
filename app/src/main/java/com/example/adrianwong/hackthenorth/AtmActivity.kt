package com.example.adrianwong.hackthenorth

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adrianwong.hackthenorth.individual.IndividualFragment
import kotlinx.android.synthetic.main.activity_atm.*

class AtmActivity : AppCompatActivity() {
    companion object{
        const val BARCODE_CHECK_ATM_REQUEST : Int = 10
    }

    private var amountInAccount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_atm)

        scanning_to_check_balance.setOnClickListener {
            val intent = Intent(this, BarCodeScannerActivity::class.java)
            startActivityForResult(intent, BARCODE_CHECK_ATM_REQUEST)
            //Todo: get uuid, make network call to get current money for that user and display.
            //make network request with uuid from activity on result
            alert()
        }

        tap_to_check_balance.setOnClickListener {
            //no operation yet
        }

        super.onCreate(savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == BARCODE_CHECK_ATM_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("result")
                result?.let {
                    if (it != "") {
                        //make network request... with uuid... return money amount...
                    }
                }
            } else {
                Toast.makeText(this, "Please try again", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun alert(){
        val builder = AlertDialog.Builder(this@AtmActivity)

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
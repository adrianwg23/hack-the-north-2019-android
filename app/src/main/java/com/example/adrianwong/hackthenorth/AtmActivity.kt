package com.example.adrianwong.hackthenorth

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_atm.*

class AtmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_atm)

        scanning_to_check_balance.setOnClickListener {
            val intent = Intent(this, BarCodeScannerActivity::class.java)
            startActivity(intent)
            //Todo: get uuid, make network call to get current money for that user and display.
        }

        tap_to_check_balance.setOnClickListener {
            //no operation yet
        }
        super.onCreate(savedInstanceState)
    }

}
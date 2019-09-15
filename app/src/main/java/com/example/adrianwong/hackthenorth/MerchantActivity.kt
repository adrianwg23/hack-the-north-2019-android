package com.example.adrianwong.hackthenorth

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_merchant.*

class MerchantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_merchant)

        scanning_to_charge.setOnClickListener {
            val intent = Intent(this, BarCodeScannerActivity::class.java)
            startActivity(intent)
            //Todo: get barcode uuid, package it along with the value of the item purchased (eg: -5)
        }
        super.onCreate(savedInstanceState)
    }

}
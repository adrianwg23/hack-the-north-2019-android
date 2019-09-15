package com.example.adrianwong.hackthenorth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adrianwong.hackthenorth.sign_in.SignInActivity
import kotlinx.android.synthetic.main.activity_demo_selection.*

class DemoSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_demo_selection)

        button1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, AtmActivity::class.java)
            startActivity(intent)
        }
        super.onCreate(savedInstanceState)
    }

}
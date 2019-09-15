package com.example.adrianwong.hackthenorth

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.adrianwong.hackthenorth.dashboard.DashboardFragment
import com.example.adrianwong.hackthenorth.individual.IndividualFragment
import com.example.adrianwong.hackthenorth.pool.PoolFragment

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_pool -> {
                val poolFragment = PoolFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, poolFragment, "").commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_individual -> {
                val individualFragment = IndividualFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, individualFragment, "").commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val dashboardFragment = DashboardFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, dashboardFragment, "").commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val poolFragment = PoolFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, poolFragment, "").commit()
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

}

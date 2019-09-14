package com.example.adrianwong.hackthenorth

import android.app.Application
import com.example.adrianwong.hackthenorth.dagger.MainComponent

class MainApplication : Application() {

    private lateinit var mainComponent: MainComponent

    override fun onCreate() {
        super.onCreate()
    }

}
package com.example.adrianwong.hackthenorth

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.example.adrianwong.hackthenorth.dagger.DaggerMainComponent
import com.example.adrianwong.hackthenorth.dagger.MainComponent
import com.example.adrianwong.hackthenorth.dagger.pool.PoolModule
import com.example.adrianwong.hackthenorth.dagger.pool.PoolSubcomponent
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

class MainApplication : Application() {

    private lateinit var mainComponent: MainComponent
    private var poolSubcomponent: PoolSubcomponent? = null

    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder()
            .build()

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("MainApplicationTag", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                Log.d("MainApplicationTag", token)
                Toast.makeText(baseContext, "INSTANCE ID: $token", Toast.LENGTH_SHORT).show()
            })
    }

    fun createPoolSubcomponent(): PoolSubcomponent {
        poolSubcomponent = mainComponent.plusPoolSubcomponent(PoolModule())
        return poolSubcomponent!!
    }

    fun releasePoolSubcompnent() {
        poolSubcomponent = null
    }

}
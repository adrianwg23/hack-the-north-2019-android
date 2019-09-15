package com.example.adrianwong.hackthenorth

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.example.adrianwong.hackthenorth.dagger.DaggerMainComponent
import com.example.adrianwong.hackthenorth.dagger.MainComponent
import com.example.adrianwong.hackthenorth.dagger.pool.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging

class MainApplication : Application() {

    private lateinit var mainComponent: MainComponent
    private var poolSubcomponent: PoolSubcomponent? = null
    private var dashboardSubcomponent: DashboardSubcomponent? = null
    private var individualSubcomponent: IndividualSubcomponent? = null
    var UUID: String = ""

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
            })

        FirebaseMessaging.getInstance().subscribeToTopic("livePool")
            .addOnCompleteListener { task ->
                var msg = "subscribed"
                if (!task.isSuccessful) {
                    msg = "failed"
                }
                Log.d("MainApplicationTag", msg)
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            }
    }

    fun createPoolSubcomponent(): PoolSubcomponent {
        poolSubcomponent = mainComponent.plusPoolSubcomponent(PoolModule())
        return poolSubcomponent!!
    }

    fun createIndividualSubcomponent(): IndividualSubcomponent {
        individualSubcomponent = mainComponent.plusIndividualSubcomponent(IndividualModule())
        return individualSubcomponent!!
    }

    fun createDashboardSubcomponent(): DashboardSubcomponent {
        dashboardSubcomponent = mainComponent.plusDashboardSubcomponent(DashboardModule())
        return dashboardSubcomponent!!
    }

    fun releasePoolSubcomponent() {
        poolSubcomponent = null
    }

    fun releaseIndividualSubcomponent() {
        individualSubcomponent = null
    }

    fun releaseDashboardSubcomponent() {
        dashboardSubcomponent = null
    }
}
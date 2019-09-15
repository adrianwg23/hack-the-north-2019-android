package com.example.adrianwong.hackthenorth.service

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val TAG = "MyFCMServiceTag"

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        Log.d(TAG, "From: ${remoteMessage.from}")

        // Check if message contains a data payload.
        remoteMessage.data.isNotEmpty().let {
            Log.d(TAG, "data: ${remoteMessage.data}")
            val intent = Intent(LIVE_POOL_TRIGGER)
            val newValue = remoteMessage.data.getValue("newValue")
            intent.putExtra(EXTRA_FCM_MESSAGE, newValue)
            sendBroadcast(intent)
        }
    }

    companion object {
        const val LIVE_POOL_TRIGGER = "LIVE_POOL_TRIGGER"
        const val EXTRA_FCM_MESSAGE = "EXTRA_FCM_MESSAGE"
    }

}
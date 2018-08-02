package com.example.wender.kotlinmessage.FirebaseServices

import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import com.example.wender.kotlinmessage.Config.Config
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService:FirebaseMessagingService(){

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        handleNotification(remoteMessage!!.notification!!.body)
    }

    private fun handleNotification(body: String?) {
        val pushNotification = Intent(Config.STR_PUSH)
        pushNotification.putExtra("message", body)
        LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification)
    }
}
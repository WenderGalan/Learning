package com.example.wender.kotlinmessage.FirebaseServices

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MyFirebaseIdService:FirebaseInstanceIdService(){
    override fun onTokenRefresh() {
        super.onTokenRefresh()
        val refreshToken = FirebaseInstanceId.getInstance().token
        sendRegistrationToServer(refreshToken!!)
    }

    private fun sendRegistrationToServer(refreshToken : String){
        Log.d("DEBUG", refreshToken);
    }
}
package com.example.wender.kotlinmessage.Config

import com.google.firebase.firestore.FirebaseFirestore

object Config{
    var STR_PUSH = "pushNotification"
    var USUARIOS = "usuarios"

    var referenciaFirestore : FirebaseFirestore = FirebaseFirestore.getInstance()


}
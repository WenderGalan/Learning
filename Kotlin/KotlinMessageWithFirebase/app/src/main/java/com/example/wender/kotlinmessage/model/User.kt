package com.example.wender.kotlinmessage.model

import com.example.wender.kotlinmessage.Config.Config
import com.example.wender.kotlinmessage.Config.Config.USUARIOS
import java.lang.Exception

class User {
    var nome: String = ""
    var idade: Int = 0
    var sexo: String = ""

    fun saveData(): Boolean {
        var retorno = false
        val data = HashMap<String, Any>()
        if (!nome.isEmpty()) data.put("nome", nome)
        if (idade != 0) data.put("idade", idade)
        if (!sexo.isEmpty()) data.put("sexo", sexo)

        Config.referenciaFirestore.collection(USUARIOS).document().set(data).addOnCompleteListener { task ->
            if (task.isSuccessful){
                retorno = true;
            }
        }.addOnFailureListener { exception ->
            if (exception != null) {
                retorno = false
            }
        }
        return retorno
    }
}
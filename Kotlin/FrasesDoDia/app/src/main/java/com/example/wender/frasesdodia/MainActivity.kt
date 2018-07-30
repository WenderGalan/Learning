package com.example.wender.frasesdodia

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    val frase = arrayOf(
            "Frase test 1",
            "Frase test 2",
            "Frase test 3",
            "Frase test 4",
            "Frase test 5"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto = findViewById(R.id.textoFrase)
    }

    fun gerarFrase(view: View) {
        val numeroAleatorio = Random().nextInt(frase.size)
        texto.setText(frase[numeroAleatorio])
    }

}

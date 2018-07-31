package com.example.wender.alcoolougasolina

import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*

@Parcelize
class MainActivity : AppCompatActivity(), Parcelable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun btCalcular(view: View) {
        //recuperar o id da visualizacao:
        val precoAlcool = edit_alcool.text.toString()
        val precoGasolina = edit_gasolina.text.toString()

        if (validarCampos(precoAlcool, precoGasolina)) {
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            text_opcao.setText("Preencha os preços primeiro!")
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.isEmpty()) {
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.isEmpty()) {
            camposValidados = false
        }
        return camposValidados
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        if (valorAlcool / valorGasolina >= 0.7) {
            text_opcao.setText("Melhor utilizar Gasolina!")
        } else {
            text_opcao.setText("Melhor utilizar Álcool!")
        }
    }
}

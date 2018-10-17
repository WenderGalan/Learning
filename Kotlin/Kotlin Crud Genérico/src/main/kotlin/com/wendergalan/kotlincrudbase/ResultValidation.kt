package com.wendergalan.kotlincrudbase

/**
 * Kotlin Crud Genérico
 * Todos os direitos reservados ©
 **********************************************
 * Nome do arquivo: ResultValidation.java
 * Criado por : Wender Galan
 * Data da criação : 09/10/2018
 * Observação :
 **********************************************
 */
class ResultValidation(var field: String, var message: String) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as ResultValidation?

        return if (if (field != null) field != that!!.field else that!!.field != null) false else !if (message != null) message != that.message else that.message != null

    }

    override fun hashCode(): Int {
        var result = if (field != null) field!!.hashCode() else 0
        result = 31 * result + if (message != null) message!!.hashCode() else 0
        return result
    }
}
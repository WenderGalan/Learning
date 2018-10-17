package com.wendergalan.kotlincrudbase

/**
 * Wender Galan LTDA
 * Todos os direitos reservados ©
 **********************************************
 * Nome do arquivo: Response.java
 * Criado por : Wender Galan
 * Data da criação : 05/10/2018
 * Observação :
 **********************************************
 */
class Response<T>(
        var erros: MutableList<ResultValidation> = mutableListOf(),
        var data: MutableList<T> = mutableListOf(),
        var size: Int = data.size)
package com.kotlinexample

/**
 * Unknown
 * TDR Informática Ltda
 * Todos os direitos reservados ©
 **********************************************
 * Nome do arquivo: User.java
 * Criado por : Wender Galan
 * Data da criação : 04/10/2018
 * Observação :
 **********************************************
 */
class User {

    lateinit var nome : String
    lateinit var telefone : String

    constructor()
    constructor(nome : String, telefone : String){
        this.nome = nome
        this.telefone = telefone
    }

    init {
        println("Entrou no init da class user")
    }
}
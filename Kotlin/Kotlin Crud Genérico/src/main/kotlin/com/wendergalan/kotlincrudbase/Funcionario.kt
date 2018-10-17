package com.wendergalan.kotlincrudbase

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

/**
 * Kotlin Crud Genérico
 * TDR Informática Ltda
 * Todos os direitos reservados ©
 **********************************************
 * Nome do arquivo: Funcionario.java
 * Criado por : Wender Galan
 * Data da criação : 09/10/2018
 * Observação :
 **********************************************
 */
@Entity
@Table(name = "funcionario")
class Funcionario : CrudController<Funcionario, Integer>() {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Integer? = null

    @NotNull(message = "O nome do usuário não pode ser nulo!")
    @NotEmpty(message = "O nome do usuário não foi informado!")
    @Column(name = "nome")
    var nome: String? = null

    @Column(name = "telefone")
    var telefone: String? = null

    @NotNull(message = "O e-mail do usuário não pode ser nulo!")
    @NotEmpty(message = "O e-mail do usuário não foi informado!")
    @Column(name = "email")
    var email: String? = null
}
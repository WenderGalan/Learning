package com.wendergalan.kotlincrudbase

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Kotlin Crud Genérico
 * TDR Informática Ltda
 * Todos os direitos reservados ©
 **********************************************
 * Nome do arquivo: FuncionarioController.java
 * Criado por : Wender Galan
 * Data da criação : 09/10/2018
 * Observação :
 **********************************************
 */
@RestController
@RequestMapping("/funcionarios")
class FuncionarioController : CrudController<Funcionario, Integer>() {

    override fun definirValorPadrao(entity: Funcionario): Boolean {
        return super.definirValorPadrao(entity)
    }

    override fun prepararRegistroAntesDeSalvar(entity: Funcionario) {
        super.prepararRegistroAntesDeSalvar(entity)
    }

    override fun aoSalvarRegistro(entity: Funcionario) {
        super.aoSalvarRegistro(entity)
    }
}
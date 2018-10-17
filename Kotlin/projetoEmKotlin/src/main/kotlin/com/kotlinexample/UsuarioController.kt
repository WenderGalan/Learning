package com.kotlinexample

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Unknown
 * TDR Informática Ltda
 * Todos os direitos reservados ©
 **********************************************
 * Nome do arquivo: UsuarioController.java
 * Criado por : Wender Galan
 * Data da criação : 04/10/2018
 * Observação :
 **********************************************
 */
@RestController
@CrossOrigin
class UsuarioController {

    //
    @RequestMapping("/")
    fun index() = "This is home!"

    //Example with Path Variable
    @GetMapping("/hello/{nome}")
    fun helloWorld(@PathVariable nome: String): String {
        return "Olá $nome"
    }

    //Example with Request Variable
    @GetMapping("/hello")
    fun helloWorld2(@RequestParam nome: String?, @RequestParam telefone: String?): ResponseEntity<User> {
        val usuario = User(nome!!, telefone!!)
        return ResponseEntity.ok(usuario)
    }

    @PostMapping("hello")
    fun saveHello(@RequestBody(required = false) user: User): ResponseEntity.BodyBuilder {
        println("O usuário chegou com sucesso na API")
        return ResponseEntity.ok()
    }




}
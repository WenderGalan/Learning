package com.wendergalan.kotlincrudbase

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.DataBinder
import org.springframework.validation.Validator
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

/**
 * Kotlin Crud Genérico
 * Todos os direitos reservados ©
 **********************************************
 * Nome do arquivo: CrudController.java
 * Criado por : Wender Galan
 * Data da criação : 09/10/2018
 * Observação :
 **********************************************
 */
abstract class CrudController<T, ID> {

    @Autowired
    protected lateinit var repository: JpaRepository<T, ID>

    @Autowired
    protected lateinit var validator: Validator

    @GetMapping("/{id}")
    open fun findById(@PathVariable("id") id: ID): ResponseEntity<Response<T>> {
        var entity: Optional<T> = repository.findById(id)
        var response: Response<T> = Response<T>()
        response.data.add(entity.get())
        return ResponseEntity.ok(response)
    }

    @GetMapping
    open fun findAll(): ResponseEntity<Response<T>> {
        var list: List<T> = repository.findAll()
        var response: Response<T> = Response<T>()
        response.data = list as MutableList<T>
        return ResponseEntity.ok(response)
    }

    @PostMapping
    open fun save(@Valid @RequestBody entity: T, result: BindingResult): ResponseEntity<Response<T>> {
        val response: Response<T> = Response<T>()
        try {
            if (definirValorPadrao(entity)) {
                var binder = DataBinder(entity)
                var bindingResult = binder.bindingResult
                validator.validate(entity, bindingResult)
                var result_ = result
                result_ = bindingResult;
            }

            if (result.hasErrors()) {
                response.erros = Util.criarListaDeErrosDaValidacao(result.allErrors) as ArrayList<ResultValidation>
                return ResponseEntity.badRequest().body(response)
            }

            prepararRegistroAntesDeSalvar(entity)

            response.data.add(repository.save(entity))

            aoSalvarRegistro(entity)

            return ResponseEntity.ok(response)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response)
        }
    }

    @PutMapping
    open fun put(@Valid @RequestBody entity: T, result: BindingResult): ResponseEntity<Response<T>> {
        val response: Response<T> = Response<T>()
        try {
            if (definirValorPadrao(entity)) {
                var binder = DataBinder(entity)
                var bindingResult = binder.bindingResult
                validator.validate(entity, bindingResult)
                var result_ = result
                result_ = bindingResult;
            }

            if (result.hasErrors()) {
                response.erros = Util.criarListaDeErrosDaValidacao(result.allErrors) as ArrayList<ResultValidation>
                return ResponseEntity.badRequest().body(response)
            }

            if (Util.getValueFromId(entity) == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            prepararRegistroAntesDeSalvar(entity)

            response.data.add(repository.save(entity))

            aoSalvarRegistro(entity)

            return ResponseEntity.ok(response)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response)
        }
    }

    @DeleteMapping("/{id}")
    open fun deleteById(@PathVariable("id") id: ID): ResponseEntity<Response<T>> {
        var sistema: T = repository.getOne(id) ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).build()

        try {
            repository.delete(sistema)
        } catch (ex: java.lang.Exception) {
            var response: Response<T> = Response<T>()
            var or: ResultValidation = ResultValidation("exception", "Não foi possível excluir está entidade!\n Erro: " + ex.message)
            response.erros.add(or)
            return ResponseEntity.ok(response)
        }
        return ResponseEntity.ok().build()
    }


    open fun definirValorPadrao(entity: T): Boolean = false
    open fun prepararRegistroAntesDeSalvar(entity: T) {}
    open fun aoSalvarRegistro(entity: T) {}

}
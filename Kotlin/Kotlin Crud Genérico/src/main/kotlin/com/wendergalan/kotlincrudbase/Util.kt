package com.wendergalan.kotlincrudbase

import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import java.lang.reflect.Field
import java.lang.reflect.InvocationTargetException
import java.util.*

/**
 * Kotlin Crud Genérico
 * TDR Informática Ltda
 * Todos os direitos reservados ©
 **********************************************
 * Nome do arquivo: Util.java
 * Criado por : Wender Galan
 * Data da criação : 09/10/2018
 * Observação :
 **********************************************
 */
object Util {
    fun criarListaDeErrosDaValidacao(errors: List<ObjectError>?): List<ResultValidation> {
        val lista = ArrayList<ResultValidation>()
        if (errors != null && !errors.isEmpty()) {
            for (error in errors) {
                if (error is FieldError) {
                    lista.add(ResultValidation(error.field, error.getDefaultMessage()!!))
                } else {
                    lista.add(ResultValidation(error.objectName, error.defaultMessage!!))
                }
            }
        }
        return lista
    }

    fun getValueFromId(entity: Any?): Any? {
        var value: Any? = null
        if (entity != null) {
            var clazz: Class<*>? = entity.javaClass

            val fields = ArrayList<Field>()
            while (clazz != null) {
                for (f in clazz.declaredFields) {
                    fields.add(f)
                }
                clazz = clazz.superclass
            }

            for (field in fields) {
                if (field.isAnnotationPresent(javax.persistence.Id::class.java) || field.isAnnotationPresent(javax.persistence.EmbeddedId::class.java)) {
                    try {
                        val nameMethod = "get" + field.name.substring(0, 1).toUpperCase() + field.name.substring(1)
                        val method = entity.javaClass.getMethod(nameMethod)
                        if (method != null) {
                            value = method.invoke(entity)
                        }
                    } catch (ex: InvocationTargetException) {
                        ex.printStackTrace(System.err)
                    } catch (ex: IllegalAccessException) {
                        ex.printStackTrace(System.err)
                    } catch (ex: NoSuchMethodException) {
                        ex.printStackTrace(System.err)
                    } finally {
                        break
                    }
                }
            }
        }

        return value
    }
}
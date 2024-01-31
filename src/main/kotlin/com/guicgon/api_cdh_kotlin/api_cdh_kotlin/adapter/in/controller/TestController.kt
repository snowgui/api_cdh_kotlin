package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.model.request.TestRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
class TestController {

    @GetMapping
    fun get(): String = "Test"

    @PostMapping
    fun anyType(@RequestBody request: TestRequest): ResponseEntity<String> {

        val value = request.value

        if (value is List<*>) {
            return ResponseEntity.ok().body(verificarTipoList(value))
        }

        val response: String = when (value) {

            is String -> "String"
            is Int -> "Int"
            is List<*> -> "List String"
            else -> "Tipo não testado!"

        }

        return ResponseEntity.ok().body(response)
    }

    private fun verificarTipoList(lst: List<*>): String {

        var res: String = "Tipo de lista não testado"
        var check: Boolean = false

        lst.forEach {
            check = tipoString(it!!)
            if (!check) {
                return res
            }
        }

        return if (check) {
            return "Tipo String totalmente válido!!!"
        } else {
            res
        }
    }

    private fun tipoString(value: Any): Boolean {

        return if (value is String) {
            true
        } else {
            false
        }
    }
}

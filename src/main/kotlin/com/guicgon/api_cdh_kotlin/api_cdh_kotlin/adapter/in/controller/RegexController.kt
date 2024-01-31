package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("regex")
class RegexController {

    @GetMapping("cpf/{value}")
    fun cpf(@PathVariable value: String): ResponseEntity<Boolean> {
        return ResponseEntity.ok(validateCpf(value))
    }

    private fun validateCpf(str: String): Boolean {
        val r = Regex("\\d{11}")
        return str.matches(r)
    }
}

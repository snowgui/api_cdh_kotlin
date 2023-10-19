package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("decision")
class DecisionController {

    @GetMapping("note-with-when/{nota}")
    fun noteWithWhen(@PathVariable nota: Int): ResponseEntity<String> {

        val response: String = when(nota){

            10, 9 -> "Fántastico"
            8, 7 -> "Parabéns"
            6, 5, 4 -> "Tem como recuperar"
            in 0..3 -> "Te vejo no próximo semestre"
            else -> "Nota inválida"

        }

        return ResponseEntity.ok().body(response)

    }
}
package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.model.obj.Carro
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("operator")
class OperatorController {

    @GetMapping("destructor")
    fun destructor(): ResponseEntity<String>{

        val (marca, modelo) = Carro("Ford", "Fusion")

        return ResponseEntity.ok().body("$marca $modelo")

    }

    @GetMapping("destructor-lst")
    fun destructorLst(): ResponseEntity<String>{

        val (nome, author) = listOf("Guia do Mochileiro das Galáxias", "Douglas Adams")

        return ResponseEntity.ok().body("$nome de $author")

    }

    @GetMapping("destructor-third")
    fun destructorThird(): ResponseEntity<String>{

        val (_, _, terceiroLugar) = listOf("Gui", "Lucy", "Maria Julia")

        return ResponseEntity.ok().body(terceiroLugar)

    }

}
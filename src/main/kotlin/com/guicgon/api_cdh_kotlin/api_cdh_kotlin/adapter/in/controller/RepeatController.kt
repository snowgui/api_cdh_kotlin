package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("repeat")
class RepeatController {

    @GetMapping("")
    fun get() : String = "repeat"

    @GetMapping("for-ten")
    fun forTen(): ResponseEntity<List<String>>{

        val lst = mutableListOf<String>()

        for(x in 1..10){
            lst.add(x.toString())
        }

        return ResponseEntity.ok().body(lst)

    }

    @GetMapping("for-net")
    fun forNet(): ResponseEntity<List<String>>{

        val lst = mutableListOf<String>()

        for(x in 10 downTo 1){
            lst.add(x.toString())
        }

        return ResponseEntity.ok().body(lst)

    }

    @GetMapping("for-ten-step/{qtd}")
    fun forStep(@PathVariable qtd: Int) : ResponseEntity<List<String>>{
        val lst = mutableListOf<String>()

        for(x in 1..10 step qtd){
            lst.add(x.toString())
        }

        return ResponseEntity.ok().body(lst)
    }

    @GetMapping("for-indice")
    fun forIndice() : ResponseEntity<List<String>>{

        val lst = arrayListOf("Guilherme", "Hyngrid", "Sammy")
        val lstResponse = mutableListOf<String>()

        for((indice, pessoa) in lst.withIndex()){
            lstResponse.add("${indice.toString()} - $pessoa")
        }

        return ResponseEntity.ok().body(lstResponse)

    }
}
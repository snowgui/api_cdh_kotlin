package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("casting")
class CastingController {

    @GetMapping("optional/value/{value}")
    fun optional(@PathVariable value: Any) : ResponseEntity<String>{

        // acrescentar o ? no casting as torna opcional
        var res = ""
        when(value as? Int ?: 0){
            10, 9 -> res = "A"
            8,7 -> res = "B"
            6,5 -> res = "C"
            4,3 -> res = "D"
            2, 1 -> res = "F"
            else -> res = "Value invalid"

        }

        return ResponseEntity.ok().body(res)
    }

    @GetMapping("smartcast")
    fun smartCast(): ResponseEntity<Any>{

        val x: Any

        x = 123

        if(x is String){
            return ResponseEntity.ok().body("x tem ${x.length} caracteres ")
        }else if(x is Int){
            return ResponseEntity.ok().body("x agora é uma ${x.toString()} string ")
        }else if(x !is Int){
            return ResponseEntity.ok().body("x agora não é Int ")
        }else{
            return ResponseEntity.ok().body("X invalid")
        }

    }
}
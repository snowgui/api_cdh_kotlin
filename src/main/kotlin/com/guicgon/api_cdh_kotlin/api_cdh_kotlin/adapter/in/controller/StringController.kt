package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("string")
class StringController {

    @GetMapping("")
    fun get() : ResponseEntity<String>{
        return ResponseEntity.ok().body("Hello World!")
    }

}

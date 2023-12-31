package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("int")
class IntController {
    @GetMapping("{value}")
    fun get(@PathVariable value: Int) : Int = value
    @GetMapping("int-or-zero", "int-or-zero/{value}")
    fun intOrZero(@PathVariable value: String?) : ResponseEntity<Int>{

        val response = value?.toIntOrNull() ?: 0

        return ResponseEntity.ok().body(response)

    }
}
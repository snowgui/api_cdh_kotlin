package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("string")
class StringController {

    @GetMapping("")
    fun get(): ResponseEntity<String> {
        return ResponseEntity.ok().body("Hello World!")
    }

    @GetMapping("completeWithValue/{len}/{value}", "completeWithValue/{len}")
    fun completeWithValue(
            @PathVariable len: Int,
            @PathVariable value: String? = "",
    ): ResponseEntity<String> {

        try {

            var strLen = ""
            val str = value ?: ""
            for (x in 1..len) strLen += "0"
            val response = ("$strLen$str").substring(str.length)

            return ResponseEntity.ok().body(response)

        } catch (ex: Exception) {
            return ResponseEntity.internalServerError().body("erro interno")
        }
    }

    @GetMapping("completeWithFourZeroValue/{value}")
    fun completeWithFourZeroValue(
            @PathVariable value: String,
    ): ResponseEntity<String> = ResponseEntity.ok().body("0000$value".substring(value.length))

    @GetMapping("completeWithFourZeroValueInt/{value}")
    fun completeWithFourZeroValueInt(
            @PathVariable value: Int,
    ): ResponseEntity<String> = ResponseEntity.ok().body(String.format("%04d", value))

}

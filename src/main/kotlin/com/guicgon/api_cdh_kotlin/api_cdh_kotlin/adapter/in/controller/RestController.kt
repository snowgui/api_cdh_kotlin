package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.out.DigimonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("rest")
 class RestController(
    private val digimonService: DigimonService
) {

    @GetMapping
    fun getDigimonByName(): ResponseEntity<Mono<String>> {

        println("Test 0")

        val response = digimonService.getDataDigimonByName()

        println("Test 1")
        println("Test 2")
        println("Test 3")

        return ResponseEntity.ok().body(response)
    }
}
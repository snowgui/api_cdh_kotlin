package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.out

import reactor.core.publisher.Mono

interface DigimonService {

    fun getDataDigimonByName(name: String = "Agumon"): Mono<String>
}
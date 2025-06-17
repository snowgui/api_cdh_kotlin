package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class WebClientConfig {

    @Bean

    fun webClient(builder: WebClient.Builder): WebClient {
        return builder.build() // Sem baseUrl fixa
    }
}
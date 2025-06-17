package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.out

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class DigimonServiceImpl(
    private val webClient: WebClient
) : DigimonService {

    override fun getDataDigimonByName(name: String): Mono<String> {

        val response = webClient.get()
            .uri("https://digimon-api.vercel.app/api/digimon/name/$name")
            .retrieve()
            .bodyToMono(String::class.java)
            .doOnSuccess {
                println("Resposta da API recebida com sucesso!")
            }
        return response

    }
}

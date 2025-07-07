package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.out

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

// Suponha que esse seja o seu DTO de resposta
data class MyResponseDto(
    val mensagem: String,
    val status: String
)

@Service
class ApiService(
    private val webClientBuilder: WebClient.Builder
) {

    fun callExternalApiAsync() {
        val webClient = webClientBuilder.baseUrl("https://exemplo.com").build()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: MyResponseDto = webClient.post()
                    .uri("/api/dados")
                    .bodyValue(mapOf("chave" to "valor"))
                    .retrieve()
                    .bodyToMono(MyResponseDto::class.java)
                    .awaitSingle() // espera a resposta, mas só dentro da coroutine

                println("✅ Sucesso! Mensagem da API: ${response.mensagem}")
            } catch (e: Exception) {
                println("❌ Erro na chamada da API: ${e.message}")
            }
        }

        println("➡️ Chamada disparada (não aguardando a resposta).")
    }
}
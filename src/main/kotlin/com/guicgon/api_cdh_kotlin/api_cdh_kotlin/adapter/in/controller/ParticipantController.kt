package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.model.obj.participant.Participante
import com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.model.request.CalculoRequest
import com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.model.response.CalculoResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.time.LocalDate

@RestController
@RequestMapping("participant")
class ParticipantController {

    @GetMapping
    fun get(): ResponseEntity<Any>{

        val participantes2 = listOf(
            Participante("Ana", "111.111.111-11", BigDecimal("30.0"), BigDecimal("3000"), LocalDate.of(2024, 1, 10)),
            Participante("Bruno", "222.222.222-22", BigDecimal("20.0"), BigDecimal("4000"), LocalDate.of(2024, 5, 15)),
            Participante("Carla", "333.333.333-33", BigDecimal("25.0"), BigDecimal("5000"), LocalDate.of(2024, 7, 1)),
            Participante("Daniel", "444.444.444-44", BigDecimal("25.0"), BigDecimal("6000"), LocalDate.of(2024, 6, 20))
        )

        val participantes = listOf(
            Participante("Ana", "111.111.111-11", BigDecimal("50.0"), BigDecimal("3000"), LocalDate.of(2024, 1, 10)),
            Participante("Bruno", "222.222.222-22", BigDecimal("50.0"), BigDecimal("4000"), LocalDate.of(2024, 5, 15)),
        )
        // total 3000
        //73 %
        //27 %
        //2190.0 -> 73
        //810.0 -> 27
        val totalRenda = BigDecimal("3000")

        val participacoes = calcularParticipacoes(participantes, totalRenda)
        println("Participações no total de R$ $totalRenda:")
        participacoes.forEach { (nome, valor) ->
            println("$nome: R$ $valor")
        }

        val maisRecente = participanteMaisRecente(participantes)
        val response = "Participante mais recente: ${maisRecente?.nome} (Cadastrado em ${maisRecente?.dataCadastro})"

        println("$response")

        return ResponseEntity.ok().body(response)
    }

    @PostMapping()
    fun post(@RequestBody request: CalculoRequest): ResponseEntity<CalculoResponse> {
        val participacoes = request.participantes.associate { participante ->
            val percentual = participante.percentualRenda.divide(BigDecimal(100))
            val contribuicao = request.totalRenda.multiply(percentual)
            participante.nome to contribuicao
        }

        val maisRecente = request.participantes.maxByOrNull { it.dataCadastro }

        val response = CalculoResponse(
            participacoes = participacoes,
            participanteMaisRecente = maisRecente?.nome ?: "Nenhum participante encontrado"
        )

        return ResponseEntity.ok(response)
    }

    fun calcularParticipacoes(participantes: List<Participante>, totalRenda: BigDecimal): Map<String, BigDecimal> {
        return participantes.associate { participante ->
            val percentual = participante.percentualRenda.divide(BigDecimal(100)) // 30.0% => 0.3
            val contribuicao = totalRenda.multiply(percentual)
            participante.nome to contribuicao
        }
    }

    fun participanteMaisRecente(participantes: List<Participante>): Participante? {
        return participantes.maxByOrNull { it.dataCadastro }
    }
}
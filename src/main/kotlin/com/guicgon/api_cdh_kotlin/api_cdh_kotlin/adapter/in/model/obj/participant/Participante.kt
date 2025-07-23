package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.model.obj.participant

import java.math.BigDecimal
import java.time.LocalDate

data class Participante(
    val nome: String,
    val cpf: String,
    val percentualRenda: BigDecimal, // Ex: 25.0 para 25%
    val renda: BigDecimal,
    val dataCadastro: LocalDate
)
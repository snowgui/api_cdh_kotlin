package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.model.response

import java.math.BigDecimal

data class CalculoResponse(
    val participacoes: Map<String, BigDecimal>,
    val participanteMaisRecente: String
)
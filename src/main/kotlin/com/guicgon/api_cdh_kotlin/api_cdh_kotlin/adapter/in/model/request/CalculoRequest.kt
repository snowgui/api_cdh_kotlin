package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.model.request

import com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.model.obj.participant.Participante
import java.math.BigDecimal

data class CalculoRequest(
    val totalRenda: BigDecimal,
    val participantes: List<Participante>
)
package com.dolina_orchestrator.dtos.responses

import java.math.BigDecimal

data class ResponseValidateItemDto(
    val itemName: String,
    val itemPrice: BigDecimal
)
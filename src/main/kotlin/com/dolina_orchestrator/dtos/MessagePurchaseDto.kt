package com.dolina_orchestrator.dtos

import java.math.BigDecimal
import java.util.UUID

data class MessagePurchaseDto(
    val globalUserId: UUID,
    val amount: BigDecimal
)

package com.dolina_orchestrator.dtos

import java.math.BigDecimal
import java.util.UUID

data class MessagePurchaseHistoryDto(
    val globalUserId: UUID,
    val globalItemId: UUID,
    val itemPrice: BigDecimal,
    val itemName: String,
    val userName: String,
    val address: String
)

package com.dolina_orchestrator.dtos.requests

import java.math.BigDecimal
import java.util.UUID

data class RequestPurchaseHistoryDto(
    val globalUserId: UUID,
    val globalItemId: UUID,
    val itemPrice: BigDecimal,
    val itemName: String,
    val userName: String,
    val address: String
)

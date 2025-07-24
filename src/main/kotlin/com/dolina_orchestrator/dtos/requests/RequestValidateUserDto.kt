package com.dolina_orchestrator.dtos.requests

import java.math.BigDecimal
import java.util.UUID

data class RequestValidateUserDto(
    val globalUserId: UUID,
    val itemPrice: BigDecimal
)
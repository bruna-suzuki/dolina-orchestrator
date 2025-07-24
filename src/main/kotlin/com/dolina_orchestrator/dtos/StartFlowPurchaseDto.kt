package com.dolina_orchestrator.dtos

import java.util.UUID

data class StartFlowPurchaseDto(
    val globalUserId: UUID,
    val globalItemId: UUID
)

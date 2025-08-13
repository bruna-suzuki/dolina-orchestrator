package com.dolina_orchestrator.dtos.requests

data class RequestEmailPurchaseDto(
    val userEmail: String,
    val userName: String,
    val itemName: String,
    val address: String
)

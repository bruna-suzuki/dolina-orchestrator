package com.dolina_orchestrator.dtos.responses

data class ResponseValidateUserDto(
    val userName: String,
    val userAddress: String,
    val userEmail: String
)
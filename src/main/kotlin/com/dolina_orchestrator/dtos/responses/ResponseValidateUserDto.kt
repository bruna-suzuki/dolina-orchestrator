package com.dolina_orchestrator.dtos.responses

data class ResponseValidateUserDto(
    val userName: String,
    val address: String,
    val email: String
)
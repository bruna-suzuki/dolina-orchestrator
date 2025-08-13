package com.dolina_orchestrator.services

import com.dolina_orchestrator.dtos.requests.RequestValidateUserDto
import com.dolina_orchestrator.dtos.responses.ResponseValidateUserDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "user-validator-client", url = "http://localhost:8081/user-validator")
interface UserValidatorClient {

    @PostMapping("/validation")
    fun userValidator(@RequestBody payload: RequestValidateUserDto): ResponseValidateUserDto?
}
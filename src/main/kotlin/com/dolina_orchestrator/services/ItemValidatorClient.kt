package com.dolina_orchestrator.services

import com.dolina_orchestrator.dtos.requests.RequestValidateItemDto
import com.dolina_orchestrator.dtos.responses.ResponseValidateItemDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "item-validator", url = "http://localhost:8086/item-validator")
interface ItemValidatorClient {

    @PostMapping("/validation")
    fun itemValidator(@RequestBody payload: RequestValidateItemDto): ResponseValidateItemDto?

}
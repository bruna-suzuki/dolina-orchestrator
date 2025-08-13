package com.dolina_orchestrator.controllers

import com.dolina_orchestrator.dtos.StartFlowPurchaseDto
import com.dolina_orchestrator.services.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/purchase")
class PurchaseItemController(private val purchaseService: PurchaseService) {

    @PostMapping
    fun purchaseItem(@RequestBody payload: StartFlowPurchaseDto): ResponseEntity<String> {
        purchaseService.purchaseItem(payload)
        return ResponseEntity.status(HttpStatus.OK).body("Funcionou!!")
    }
}
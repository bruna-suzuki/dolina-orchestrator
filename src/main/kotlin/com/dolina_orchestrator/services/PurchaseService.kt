package com.dolina_orchestrator.services

import com.dolina_orchestrator.dtos.StartFlowPurchaseDto
import com.dolina_orchestrator.dtos.requests.RequestValidateItemDto
import com.dolina_orchestrator.dtos.requests.RequestValidateUserDto
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val itemValidatorClient: ItemValidatorClient,
    private val userValidatorClient: UserValidatorClient) {

    fun purchaseItem(payload: StartFlowPurchaseDto) {
        val itemRequest = RequestValidateItemDto(payload.globalItemId)
        val itemValidator = itemValidatorClient.itemValidator(itemRequest)
        println(itemValidator)

        val userRequest = RequestValidateUserDto(payload.globalUserId, itemValidator!!.itemPrice)
        val userValidator = userValidatorClient.userValidator(userRequest)
        println(userValidator)
    }
}
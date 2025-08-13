package com.dolina_orchestrator.services

import com.dolina_orchestrator.dtos.StartFlowPurchaseDto
import com.dolina_orchestrator.dtos.requests.RequestEmailPurchaseDto
import com.dolina_orchestrator.dtos.requests.RequestPurchaseHistoryDto
import com.dolina_orchestrator.dtos.requests.RequestValidateItemDto
import com.dolina_orchestrator.dtos.requests.RequestValidateUserDto
import com.dolina_orchestrator.producer.EmailPurchaseProducer
import com.dolina_orchestrator.producer.PurchaseHistoryProducer
import com.dolina_orchestrator.producer.PurchaseProducer
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val itemValidatorClient: ItemValidatorClient,
    private val userValidatorClient: UserValidatorClient,
    private val purchaseProducer: PurchaseProducer,
    private val purchaseHistoryProducer: PurchaseHistoryProducer,
    private val emailPurchaseProducer: EmailPurchaseProducer
) {

    fun purchaseItem(payload: StartFlowPurchaseDto) {
        val itemRequest = RequestValidateItemDto(payload.globalItemId)
        val itemValidator = itemValidatorClient.itemValidator(itemRequest)
        println(itemValidator)

        val userRequest = RequestValidateUserDto(payload.globalUserId, itemValidator!!.itemPrice)
        val userValidator = userValidatorClient.userValidator(userRequest)
            ?: throw Exception("User not found.")
        println(userValidator)

        purchaseProducer.updateUserBalance(userRequest)

        //instanciar o RequestPurchaseHistoryDto
        val messagePurchaseHistory = RequestPurchaseHistoryDto(
            payload.globalUserId,
            payload.globalItemId,
            itemValidator.itemPrice,
            itemValidator.itemName,
            userValidator.userName, //to-do: tratar exception caso userValidator seja null
            userValidator.address //to-do: tratar exception caso userValidator seja null
        )

        purchaseHistoryProducer.savePurchaseHistory(messagePurchaseHistory)

        val messagePurchaseEmail = RequestEmailPurchaseDto(
            userEmail = userValidator.email,
            userName = userValidator.userName,
            itemName = itemValidator.itemName,
            address = userValidator.address
        )

        emailPurchaseProducer.savePurchaseEmail(messagePurchaseEmail)
    }
}
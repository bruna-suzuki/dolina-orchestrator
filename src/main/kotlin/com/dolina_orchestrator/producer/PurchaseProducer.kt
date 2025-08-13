package com.dolina_orchestrator.producer

import com.dolina_orchestrator.dtos.MessagePurchaseDto
import com.dolina_orchestrator.dtos.requests.RequestValidateUserDto
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class PurchaseProducer(private val rabbitTemplate: RabbitTemplate) {

    @Value("\${broker.queue.purchase.name}")
    lateinit var queueName: String

    fun updateUserBalance(data: RequestValidateUserDto) {
        val message = MessagePurchaseDto(
            globalUserId = data.globalUserId,
            amount = data.amount
        )
        rabbitTemplate.convertAndSend("", queueName, message)
    }
}
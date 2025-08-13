package com.dolina_orchestrator.producer

import com.dolina_orchestrator.dtos.requests.RequestEmailPurchaseDto
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EmailPurchaseProducer(private val rabbitTemplate: RabbitTemplate) {

    @Value("\${broker.queue.purchase.email}")
    lateinit var emailQueue: String

    fun savePurchaseEmail(message: RequestEmailPurchaseDto) {

        rabbitTemplate.convertAndSend("", emailQueue, message)
    }
}
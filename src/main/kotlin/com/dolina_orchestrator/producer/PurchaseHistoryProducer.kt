package com.dolina_orchestrator.producer

import com.dolina_orchestrator.dtos.requests.RequestPurchaseHistoryDto
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class PurchaseHistoryProducer(private val rabbitTemplate: RabbitTemplate) {

    @Value("\${broker.queue.purchase.history}")
    lateinit var historyQueue: String

    fun savePurchaseHistory(message: RequestPurchaseHistoryDto) {

        rabbitTemplate.convertAndSend("", historyQueue, message)
    }
}
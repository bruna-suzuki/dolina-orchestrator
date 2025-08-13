package com.dolina_orchestrator.configs

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig{

    @Value("\${broker.queue.purchase.name}")
    lateinit var purchaseUserQueue: String

    @Value("\${broker.queue.purchase.history}")
    lateinit var purchaseHistoryQueue: String

    @Value("\${broker.queue.purchase.email}")
    lateinit var purchaseEmailQueue: String


    @Bean
    fun createQueuePurchase(): Queue {
        return Queue(purchaseUserQueue, true)
    }

    @Bean
    fun createPurchaseHistoryQueue(): Queue {
        return Queue(purchaseHistoryQueue,true)
    }

    @Bean
    fun createPurchaseEmailQueue(): Queue {
        return Queue(purchaseEmailQueue, true)
    }

    @Bean
    fun convertMessage(): Jackson2JsonMessageConverter {
        val objectMapper = ObjectMapper()
        return Jackson2JsonMessageConverter(objectMapper)
    }
}
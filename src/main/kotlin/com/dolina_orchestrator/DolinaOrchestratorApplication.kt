package com.dolina_orchestrator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class DolinaOrchestratorApplication

fun main(args: Array<String>) {
	runApplication<DolinaOrchestratorApplication>(*args)
}

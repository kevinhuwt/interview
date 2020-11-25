package com.example.rabbitmqclient

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitmqclientApplication : CommandLineRunner {

    @Autowired
    private val rabbitTemplate: RabbitTemplate? = null

    override fun run(vararg args: String?) {
        rabbitTemplate!!.convertAndSend("MyExchange", "topic", "Apple Apple apple orange")
    }
}



fun main(args: Array<String>) {
    runApplication<RabbitmqclientApplication>(*args)
}

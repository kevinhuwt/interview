package com.example.rabbitmqlistener

import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.MessageListenerContainer
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {
    //    @Bean
    fun myTestQueue(): Queue {
        return QueueBuilder.durable(TEST_QUEUE)
                .autoDelete()
                .build()
    }

    //    @Bean
    fun myTestExchange(): Exchange {
        return ExchangeBuilder.topicExchange(TEST_EXCHANGE)
                .autoDelete()
                .durable(true)
                .build()
    }

    //    @Bean
    fun queueBinding(): Binding {
        return BindingBuilder
                .bind(myTestQueue())
                .to(myTestExchange())
                .with("topic")
                .noargs()
    }

    @Bean
    fun connectionFactory(): ConnectionFactory {
        val connectionFactory = CachingConnectionFactory("localhost")
        connectionFactory.username = "guest"
        connectionFactory.setPassword("guest")
        return connectionFactory
    }

    @Bean
    fun messageListenerContainer(): MessageListenerContainer {
        val simpleMessageListenerContainer = SimpleMessageListenerContainer()
        simpleMessageListenerContainer.connectionFactory = connectionFactory()
        simpleMessageListenerContainer.setQueues(myTestQueue())
        simpleMessageListenerContainer.setMessageListener(RabbitListener())
        return simpleMessageListenerContainer
    }

    companion object {
        private const val TEST_QUEUE = "TestQueue"
        private const val TEST_EXCHANGE = "MyExchange"
    }
}

package com.example.rabbitmqlistener

import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageListener


class RabbitListener : MessageListener {
    override fun onMessage(message: Message) {
        println(receiveOrder(String(message.body)))
    }

    fun receiveOrder(order: String): String {
        val items = order.split(" ").toTypedArray()
        var apple = 0
        var orange = 0
        for (item in items) {
            val lowerCaseItem = item.toLowerCase()
            if (lowerCaseItem == "apple") {
                apple += 1
            }
            if (lowerCaseItem == "orange") {
                orange += 1
            }
            if (apple > 2 || orange > 2) {
                return "OUT OF STOCK"
            }
        }
        return "You have successfully purchased, it will be delivered to your home next Monday"
    }
}
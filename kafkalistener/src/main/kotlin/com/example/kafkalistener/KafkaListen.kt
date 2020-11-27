package com.example.kafkalistener

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class KafkaListen {
    @KafkaListener(topics = ["topic"], groupId = "group_id")
    fun receiveOrder(message: String) {
        val items = message.substring(1, message.length - 1).split(" ").toTypedArray()
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
                println("OUT OF STOCK")
                return
            }
        }
        println("You have successfully purchased, it will be delivered to your home next Monday")
    }
}

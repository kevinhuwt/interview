package com.example.kafkaclient

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("")
class MainController {

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    @GetMapping("/order")
    fun order(@RequestParam("apple") apple: Int,
              @RequestParam("orange") orange: Int) {
        var appleNum = apple
        var orangeNum = orange

        val msg = StringBuilder()
        while (appleNum > 0) {
            msg.append("apple ")
            appleNum--
        }
        while (orangeNum > 0) {
            msg.append("orange ")
            orangeNum--
        }
        kafkaTemplate?.send("topic", msg.toString())
    }

}

package com.example.kafkalistener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkalistenerApplication

fun main(args: Array<String>) {
    runApplication<KafkalistenerApplication>(*args)
}

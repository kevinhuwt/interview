package com.example.kafkaclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaclientApplication

fun main(args: Array<String>) {
    runApplication<KafkaclientApplication>(*args)
}

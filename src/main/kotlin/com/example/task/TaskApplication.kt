package com.example.task

import com.example.task.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskApplication : CommandLineRunner {

    @Autowired
    private lateinit var productService : ProductService

    override fun run(vararg args: String?) {
        val totalPrice : Double = productService.getTotalPrice(args as Array<String>)
        println("Total Price is $totalPrice")
    }
}

fun main(args: Array<String>) {
    runApplication<TaskApplication>(*args)
}

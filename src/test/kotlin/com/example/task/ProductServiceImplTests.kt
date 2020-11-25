package com.example.task

import com.example.task.service.ProductService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import org.junit.Assert.*

@SpringBootTest
class ProductServiceImplTests {

    @Autowired
    private lateinit var productService: ProductService

    @Test
    @Throws(Exception::class)
    fun testTotalPrice() {
        val total = productService.getTotalPrice(arrayOf("Apple", "Apple", "Orange"))
        // 0.6 + 0 + 0.25 = 0.85
        assertEquals(0.85, total, 0.0)
    }

    @Test
    @Throws(Exception::class)
    fun testTotalPrice2() {
        val total = productService.getTotalPrice(arrayOf("Apple", "Apple", "Orange", "Orange", "Orange"))
        // 0.6 + 0 + 0.25 + 0.25 + 0 = 1.1
        assertEquals(1.1, total, 0.0)
    }
}

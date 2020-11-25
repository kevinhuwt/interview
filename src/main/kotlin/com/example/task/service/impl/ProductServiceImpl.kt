package com.example.task.service.impl

import com.example.task.service.ProductService
import org.springframework.stereotype.Component

@Component
class ProductServiceImpl : ProductService{

    override fun getTotalPrice(products: Array<String>): Double {
        val applePrice = 0.6
        val orangePrice = 0.25

        var total = 0.0

        var nextFreeApple = 0
        var nextFreeOrange = 0

        for (product in products){
            val lowerCaseProduct : String = product.toLowerCase()

            if (lowerCaseProduct == "apple") {
                if (nextFreeApple == 1) {
                    nextFreeApple = 0

                }
                else {
                    nextFreeApple += 1
                    total += applePrice
                }
            }
            if (lowerCaseProduct == "orange") {
                if (nextFreeOrange == 2){
                    nextFreeOrange = 0;
                }
                else {
                    nextFreeOrange += 1
                    total += orangePrice
                }
            }

        }
        return total
    }

}
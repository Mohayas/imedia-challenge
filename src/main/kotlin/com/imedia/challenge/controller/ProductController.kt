package com.imedia.challenge.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {
    @GetMapping( "/product/{productId}")
    fun getProduct(@PathVariable(name = "productId") productId: Int): String {

        return "productId : $productId"
    }
    @GetMapping( "/")
    fun ge(): String {
        return "productId : "
    }
}
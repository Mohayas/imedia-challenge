package com.imedia.challenge.controller

import com.imedia.challenge.model.Product
import com.imedia.challenge.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping("/product/{productId}")
    fun getProduct(@PathVariable(name = "productId") productId: Integer): ResponseEntity<Product?> {

       var product = productService.findById(productId)
        if(product.isPresent) return   ResponseEntity< Product ?>(product.get(), HttpStatus.OK)
        return ResponseEntity<Product ?>(null, HttpStatus.NOT_FOUND)
    }

    @PostMapping("/product")
    fun save(): ResponseEntity<Product> {
        var product = Product(0, "title", "pSubtitle", "Some desc here", 12.99)
        product = productService.save(product);
        return ResponseEntity< Product >(product, HttpStatus.CREATED)
    }
}
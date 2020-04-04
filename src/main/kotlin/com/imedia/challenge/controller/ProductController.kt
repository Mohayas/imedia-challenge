package com.imedia.challenge.controller

import com.imedia.challenge.model.Product
import com.imedia.challenge.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping("/product/{productId}")
    fun findById(@PathVariable(name = "productId") productId: Int): ResponseEntity<*> {
        var product = productService.findById(productId)
        if (product.isPresent) return ResponseEntity<Product?>(product.get(), HttpStatus.OK)
        return ResponseEntity<String>("No product found", HttpStatus.NOT_FOUND)
    }

    @GetMapping("/product/all")
    fun getAll(): ResponseEntity<*> {
        return ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK)
    }

    @PostMapping("/product")
    fun save(@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity<Product>(productService.save(product), HttpStatus.CREATED)
    }

    @PutMapping("/product")
    fun update(@RequestBody product: Product): ResponseEntity<*> {
        if (productService.update(product))
            return ResponseEntity<String>("", HttpStatus.OK)
        return ResponseEntity<String>("", HttpStatus.BAD_REQUEST)

    }

    @DeleteMapping("/product/{productId}")
    fun delete(@PathVariable(name = "productId") productId: Int): ResponseEntity<*> {
        return ResponseEntity(productService.delete(productId), HttpStatus.NO_CONTENT)
    }
}
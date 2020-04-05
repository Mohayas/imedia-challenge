package com.imedia.challenge.controller

import com.imedia.challenge.dto.ProductDto
import com.imedia.challenge.dto.RatingDto
import com.imedia.challenge.model.Product
import com.imedia.challenge.service.ProductService
import com.imedia.challenge.service.RatingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/product")
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @Autowired
    lateinit var ratingService: RatingService

    @GetMapping("/{productId}")
    fun findById(@PathVariable(name = "productId") productId: Int): ResponseEntity<*> {
        var productDto = productService.findById(productId)
        if (productDto != null) return ResponseEntity<ProductDto?>(productDto, HttpStatus.OK)
        return ResponseEntity<String>("No product found", HttpStatus.NOT_FOUND)
    }

    @GetMapping("/all")
    fun getAll(): ResponseEntity<*> {
        return ResponseEntity<List<ProductDto>>(productService.getAll(), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody product: ProductDto): ResponseEntity<ProductDto> {
        return ResponseEntity<ProductDto>(productService.save(product), HttpStatus.CREATED)
    }

    @PutMapping
    fun update(@RequestBody productDto: ProductDto): ResponseEntity<*> {
        if (productService.update(productDto))
            return ResponseEntity<String>("", HttpStatus.OK)
        return ResponseEntity<String>("", HttpStatus.BAD_REQUEST)

    }

    @DeleteMapping("/{productId}")
    fun delete(@PathVariable(name = "productId") productId: Int): ResponseEntity<*> {
        return ResponseEntity(productService.delete(productId), HttpStatus.NO_CONTENT)
    }

    @PostMapping("/{productId}/rating")
    fun rate(@RequestBody ratingDto: RatingDto, @PathVariable(name = "productId") productId: Int): ResponseEntity<*> {

        ratingDto.productId = productId
        var rating = ratingService.save(ratingDto)
        if (rating == null) return ResponseEntity("", HttpStatus.BAD_REQUEST)
        return ResponseEntity(rating, HttpStatus.CREATED)
    }

    @GetMapping("/{productId}/ratings")
    fun getAllProductRatings(@PathVariable(name = "productId") productId: Int): ResponseEntity<*> {

        return ResponseEntity<List<RatingDto>>(ratingService.getAllByProductId(productId), HttpStatus.OK)
    }

}
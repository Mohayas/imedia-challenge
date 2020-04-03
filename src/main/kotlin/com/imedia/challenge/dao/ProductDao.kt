package com.imedia.challenge.dao

import com.imedia.challenge.model.Product
import com.imedia.challenge.repository.ProductJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductDao {

    @Autowired
    lateinit var productJpaRepository: ProductJpaRepository;

    fun save(product: Product): Product {
        return productJpaRepository.save(product);
    }
    fun findById(productId: Integer): Optional<Product> {
        return productJpaRepository.findById(productId)
    }
}
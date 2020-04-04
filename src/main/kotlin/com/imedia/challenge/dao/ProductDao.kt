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

    fun saveOrUpdate(product: Product): Product {
        return productJpaRepository.save(product);
    }

    fun findById(productId: Int): Optional<Product> {
        return productJpaRepository.findById(productId)
    }

    fun delete(productId: Int){
        if(productJpaRepository.existsById(productId))
        return productJpaRepository.deleteById(productId)
    }
    fun getAll(): List<Product> {
        return productJpaRepository.findAll();
    }

}
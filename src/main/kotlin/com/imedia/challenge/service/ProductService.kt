package com.imedia.challenge.service

import com.imedia.challenge.dao.ProductDao
import com.imedia.challenge.dto.ProductDto
import com.imedia.challenge.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService {

    @Autowired
    lateinit var productDao : ProductDao

    fun findById(produtId : Integer) : Optional<Product> {
        return productDao.findById(produtId)
    }

    fun save(product : Product) : Product {
        return productDao.save(product);
    }

}
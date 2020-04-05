package com.imedia.challenge.service

import com.imedia.challenge.dao.ProductDao
import com.imedia.challenge.dto.ProductDto
import com.imedia.challenge.mapper.Mapper
import com.imedia.challenge.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductService {

    @Autowired
    lateinit var productDao: ProductDao

    @Autowired
    lateinit var mapper: Mapper

    fun findById(produtId: Int): ProductDto? {
        var product = productDao.findById(produtId)
        if (product.isPresent)
            return mapper.productToProductDto(product.get())
        return null
    }

    fun save(productDto: ProductDto): ProductDto {

        val  product = mapper.productDtoToProduct(productDto)
        val productDto = mapper.productToProductDto( productDao.saveOrUpdate(product));
        return productDto
    }

    fun update(product: Product): Boolean {
        if (productDao.findById(product.id).isEmpty) return false;
        productDao.saveOrUpdate(product)
        return true;
    }

    fun delete(productId: Int) {
        productDao.delete(productId)
    }

    fun getAll(): List<ProductDto> {
        var products = productDao.getAll()
        return products.stream().map { product -> mapper.productToProductDto(product) }.collect(Collectors.toList())
    }
}
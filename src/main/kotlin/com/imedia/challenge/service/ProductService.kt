package com.imedia.challenge.service

import com.imedia.challenge.dao.ProductDao
import com.imedia.challenge.dto.ProductDto
import com.imedia.challenge.mapper.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ProductService {

    @Autowired
    lateinit var productDao: ProductDao

    @Autowired
    lateinit var mapper: Mapper

    fun findById(productId: Int): ProductDto? {
        val product = productDao.findById(productId)
        if (product.isPresent)
            return mapper.productToProductDto(product.get())
        return null
    }

    fun save(productDto: ProductDto): ProductDto {

        val  product = mapper.productDtoToProduct(productDto)
        return mapper.productToProductDto( productDao.saveOrUpdate(product))
    }

    fun update(productDto: ProductDto): Boolean {
        if (productDao.findById(productDto.id).isEmpty) return false
        val  product = mapper.productDtoToProduct(productDto)
        productDao.saveOrUpdate(product)
        return true
    }

    fun delete(productId: Int) {
        productDao.delete(productId)
    }

    fun getAll(): List<ProductDto> {
        val products = productDao.getAll()
        return products.stream().map { product -> mapper.productToProductDto(product) }.collect(Collectors.toList())
    }
}
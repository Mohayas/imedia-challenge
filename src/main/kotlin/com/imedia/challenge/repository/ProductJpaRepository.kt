package com.imedia.challenge.repository

import com.imedia.challenge.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductJpaRepository : JpaRepository<Product, Integer>{
}
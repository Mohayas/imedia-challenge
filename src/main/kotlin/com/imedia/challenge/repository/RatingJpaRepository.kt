package com.imedia.challenge.repository

import com.imedia.challenge.model.Product
import com.imedia.challenge.model.Rating
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RatingJpaRepository : JpaRepository<Rating, Int>{
}
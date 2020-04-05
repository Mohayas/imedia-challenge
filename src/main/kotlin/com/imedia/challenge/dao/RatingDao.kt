package com.imedia.challenge.dao

import com.imedia.challenge.model.Rating
import com.imedia.challenge.repository.RatingJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class RatingDao {

    @Autowired
    lateinit var ratingJpaRepository: RatingJpaRepository

    fun saveOrUpdate(rating: Rating): Rating {
        return ratingJpaRepository.save(rating)
    }

    fun findById(ratingId: Int): Optional<Rating> {
        return ratingJpaRepository.findById(ratingId)
    }

    fun delete(ratingId: Int) {
        if (ratingJpaRepository.existsById(ratingId))
            return ratingJpaRepository.deleteById(ratingId)
    }

    fun getAll(): List<Rating> {
        return ratingJpaRepository.findAll()
    }

}
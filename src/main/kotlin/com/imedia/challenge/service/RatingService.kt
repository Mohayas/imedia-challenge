package com.imedia.challenge.service

import com.imedia.challenge.dao.ProductDao
import com.imedia.challenge.dao.RatingDao
import com.imedia.challenge.dto.RatingDto
import com.imedia.challenge.mapper.Mapper
import com.imedia.challenge.model.Rating
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RatingService {

    @Autowired
    lateinit var ratingDao: RatingDao

    @Autowired
    lateinit var productDao: ProductDao

    @Autowired
    lateinit var mapper: Mapper

    fun findById(ratingId: Int): RatingDto? {
        val rating = ratingDao.findById(ratingId)
        if (rating.isPresent)
            return mapper.ratingToRatingDto(rating.get())
        return null;
    }

    fun save(ratingDto: RatingDto): RatingDto? {

        if (productDao.findById(ratingDto.productId).isEmpty) return null
        var rating = mapper.ratingDtoToRating(ratingDto)
        rating = ratingDao.saveOrUpdate(rating)
        return mapper.ratingToRatingDto(rating)
    }

    fun update(ratingDto: RatingDto): Boolean {

        if (ratingDao.findById(ratingDto.id).isEmpty) return false;

        val rating = mapper.ratingDtoToRating(ratingDto)
        ratingDao.saveOrUpdate(rating)

        return true;
    }

    fun delete(ratingId: Int) {
        ratingDao.delete(ratingId)
    }

    fun getAll(): List<RatingDto> {
        val ratings = ratingDao.getAll()
        return ratings.stream().map { rating -> mapper.ratingToRatingDto(rating) }.collect(Collectors.toList())
    }
}
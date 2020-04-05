package com.imedia.challenge.mapper

import com.imedia.challenge.dto.ImageDto
import com.imedia.challenge.dto.ProductDto
import com.imedia.challenge.dto.RatingDto
import com.imedia.challenge.model.Image
import com.imedia.challenge.model.Product
import com.imedia.challenge.model.Rating
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class Mapper {

    fun productToProductDto(product: Product): ProductDto {

        var productDto = ProductDto(product.id, product.title, product.subTitle, product.description, product.price)

        productDto.images = product.images.stream().map { img -> ImageDto(img.id, img.path) }.collect(Collectors.toList());
        productDto.ratings = product.ratings.stream().map { rating -> ratingToRatingDto(rating) }.collect(Collectors.toList())

        return productDto
    }

    fun productDtoToProduct(productDto: ProductDto): Product {

        var product = Product()
        product.id = productDto.id
        product.title = productDto.title
        product.subTitle = productDto.subTitle
        product.description = productDto.description
        product.price = productDto.price

        product.images = productDto.images.stream().map { img -> Image(img.id, img.path, product) }.collect(Collectors.toList());
        //product.ratings = productDto.ratings.stream().map { rating -> ratingDtoToRating(rating) }.collect(Collectors.toList())
        return product
    }

    fun ratingToRatingDto(rating: Rating): RatingDto {

        var ratingtDto = RatingDto(rating.id, rating.comment, rating.title, rating.numberOfStars, rating.product.id)
        return ratingtDto
    }

    fun ratingDtoToRating(ratingDto: RatingDto): Rating {

        val product = Product()
        product.id = ratingDto.productId
        var rating = Rating(ratingDto.id, ratingDto.comment, ratingDto.title, ratingDto.numberOfStars, product)
        return rating
    }
}
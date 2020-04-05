package com.imedia.challenge.dto

data class ProductDto(
        val id: Int = 0,
        val title: String = "",
        val subTitle: String = "",
        val description: String = "",
        val price: Double = 0.0,
        var ratings: List<RatingDto> = emptyList(),
        var images: List<ImageDto> = emptyList()
)
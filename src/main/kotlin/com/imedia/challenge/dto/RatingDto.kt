package com.imedia.challenge.dto

data class RatingDto(
        val id: Int,
        val comment: String,
        val title: String,
        val numberOfStars: Int,
        var productId: Int
)
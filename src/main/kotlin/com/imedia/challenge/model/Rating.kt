package com.imedia.challenge.model

import javax.persistence.*

@Entity
@Table
data class Rating (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Int,
        @Column
        val comment : String,
        @Column
        val title : String,
        @Column
        val numberOfStars : Int
)
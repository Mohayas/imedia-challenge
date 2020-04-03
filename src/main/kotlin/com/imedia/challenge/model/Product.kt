package com.imedia.challenge.model

import javax.persistence.*

@Entity
@Table
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int=0,
        @Column
        val title: String="",
        @Column
        val subTitle: String="",
        @Column
        val description: String="",
        @Column
        val price: Double= 0.0)
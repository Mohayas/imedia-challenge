package com.imedia.challenge.model

import javax.persistence.*

@Entity
@Table
data class Image (
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        val id :Int,
        @Column
        val path : String
)
package com.imedia.challenge.model

import javax.persistence.*

@Entity
@Table
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    @Column
    var title: String = ""

    @Column
    var subTitle: String = ""

    @Column
    var description: String = ""

    @Column
    var price: Double = 0.0

    @OneToMany(mappedBy = "product", cascade = arrayOf(CascadeType.REMOVE),  fetch = FetchType.LAZY)
    var ratings: List<Rating> = emptyList()

    @OneToMany(mappedBy = "product", cascade = arrayOf(CascadeType.PERSIST,CascadeType.REMOVE), fetch = FetchType.EAGER)
    var images: List<Image> = emptyList()

}
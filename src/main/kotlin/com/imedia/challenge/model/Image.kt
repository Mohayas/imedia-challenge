package com.imedia.challenge.model

import javax.persistence.*

@Entity
@Table
class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    @Column
    var path: String =""

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    lateinit var product: Product

    constructor(id: Int, path: String, product: Product) {
        this.id = id
        this.path = path
        this.product = product
    }
}
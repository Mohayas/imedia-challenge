package com.imedia.challenge.model

import javax.persistence.*

@Entity
@Table
 class Rating {
       @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int=0
        @Column
        var comment : String=""
        @Column
        var title : String=""
        @Column
        var numberOfStars : Int=0

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "product_id")
        lateinit var product: Product

       constructor(id: Int, comment: String, title: String, numberOfStars: Int, product: Product) {
              this.id = id
              this.comment = comment
              this.title = title
              this.numberOfStars = numberOfStars
              this.product = product
       }
}
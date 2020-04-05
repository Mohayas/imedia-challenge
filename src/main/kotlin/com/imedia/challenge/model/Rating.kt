package com.imedia.challenge.model

import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

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
        @Min(0,message = "The number of stars MUST NOT be negative value.")
        @Max(5,message = "The number of stars MUST NOT be more than 5.")
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
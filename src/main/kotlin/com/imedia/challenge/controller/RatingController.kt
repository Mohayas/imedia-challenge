package com.imedia.challenge.controller

import com.imedia.challenge.dto.RatingDto
import com.imedia.challenge.service.RatingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/rating")
class RatingController {

    @Autowired
    lateinit var ratingService: RatingService

    @GetMapping("/{ratingId}")
    fun findById(@PathVariable(name = "ratingId") ratingId: Int): ResponseEntity<*> {

        val ratingDto = ratingService.findById(ratingId)
        if (ratingDto != null) return ResponseEntity<RatingDto>(ratingDto, HttpStatus.OK)
        return ResponseEntity<String>("No rating found", HttpStatus.NOT_FOUND)

    }

    @PutMapping
    fun update(@RequestBody ratingDto: RatingDto): ResponseEntity<*> {

        return ResponseEntity<Boolean>(ratingService.update(ratingDto), HttpStatus.OK)
    }

    @DeleteMapping("/{ratingId}")
    fun delete(@PathVariable(name = "ratingId") ratingId: Int): ResponseEntity<*> {
        return ResponseEntity(ratingService.delete(ratingId), HttpStatus.NO_CONTENT)
    }


}
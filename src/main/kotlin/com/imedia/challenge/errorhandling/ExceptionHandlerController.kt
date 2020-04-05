package com.imedia.challenge.errorhandling

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.RuntimeException
import java.time.LocalDateTime
import java.util.stream.Collectors
import javax.validation.ConstraintViolationException


@ControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(exception: RuntimeException?): ResponseEntity<Any?>? {
        return ResponseEntity(ExceptionResponseDto(LocalDateTime.now(), 500, exception?.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationException(exception: ConstraintViolationException?): ResponseEntity<Any?>? {
        return ResponseEntity(ExceptionResponseDto(LocalDateTime.now(), 500, exception?.constraintViolations?.stream()?.map { cons -> cons.message }?.findFirst()?.get()), HttpStatus.BAD_REQUEST)
    }
}
package com.imedia.challenge.errorhandling

import java.sql.Timestamp
import java.time.LocalDateTime

data class ExceptionResponseDto(

        val timestamp: LocalDateTime,
        val status: Int,
        val message: String?


)
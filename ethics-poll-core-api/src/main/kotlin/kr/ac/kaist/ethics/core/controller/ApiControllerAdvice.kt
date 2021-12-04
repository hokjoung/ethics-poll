package kr.ac.kaist.ethics.core.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<Any> {
        logger.error("Exception : {}", e.message, e)
        return ResponseEntity(null, HttpStatus.BAD_REQUEST)
    }
}

package com.example.todolist.controller.exception

import com.example.todolist.response.ResponseModel
import org.hibernate.MappingException
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ResourceExceptionHandler {

    private fun getResponseFailure(status: HttpStatus, message: String): ResponseEntity<ResponseModel<String>>? {
        val err = ResponseModel<String>(null)
                .withHttpStatus(status)
                .withMessage(message)
        return ResponseEntity
                .status(status)
                .contentType(MediaType.valueOf("application/json;charset=UTF-8"))
                .body(err)
    }

    @ExceptionHandler(Exception::class)
    fun exception(e: Exception, request: HttpServletRequest): ResponseEntity<ResponseModel<String>>? {
        return getResponseFailure(HttpStatus.INTERNAL_SERVER_ERROR, e.message.toString())
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun httpMessageNotReadableException(e: HttpMessageNotReadableException, request: HttpServletRequest): ResponseEntity<ResponseModel<String>>? {
        return getResponseFailure(HttpStatus.BAD_REQUEST, "Erro no json recebido: ${e.message}")
    }

    @ExceptionHandler(MappingException::class)
    fun mappingException(e: MappingException, request: HttpServletRequest): ResponseEntity<ResponseModel<String>>? {
        return getResponseFailure(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao mappear: ${e.message}")
    }

    @ExceptionHandler(NotFoundException::class)
    fun notFoundException(e: NotFoundException, request: HttpServletRequest): ResponseEntity<ResponseModel<String>>? {
        return getResponseFailure(HttpStatus.NOT_FOUND, e.message.toString())
    }

    @ExceptionHandler(ForbiddenException::class)
    fun forbiddenException(e: ForbiddenException, request: HttpServletRequest): ResponseEntity<ResponseModel<String>>? {
        return getResponseFailure(HttpStatus.FORBIDDEN, e.message.toString())
    }
}
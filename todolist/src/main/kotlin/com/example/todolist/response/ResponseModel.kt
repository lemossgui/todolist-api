package com.example.todolist.response

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ResponseModel<T> {
    var status: String? = null
    var params: T? = null
    var message: String? = null

    @JsonIgnore
    var httpStatus: HttpStatus
        set(value) {
            this.status = if (successHttpCodeList.contains(value)) ResponseStatus.SUCCESS.getStatus()
            else ResponseStatus.FAILURE.getStatus()
            field = value
        }

    private val successHttpCodeList: List<HttpStatus>
        get() {
            return listOf(
                    HttpStatus.OK,
                    HttpStatus.CREATED,
            )
        }

    constructor(params: T?) {
        this.params = params
        this.httpStatus = HttpStatus.OK
    }

    fun withHttpStatus(httpStatus: HttpStatus): ResponseModel<T> {
        this.httpStatus = httpStatus
        return this
    }

    fun withMessage(message: String): ResponseModel<T> {
        this.message = message
        return this
    }

    fun build(): ResponseEntity<ResponseModel<T>> {
        return ResponseEntity.status(this.httpStatus).body(this)
    }
}


package com.example.todolist.response

enum class ResponseStatus(private val message: String) {

    SUCCESS("success"),
    FAILURE("failure");

    fun getStatus(): String {
        return message
    }
}
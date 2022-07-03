package com.example.todolist.service.authentication

import org.springframework.stereotype.Service

@Service
interface AuthentiationService {
    fun doLogin(username: String, password: String): String
}
package com.example.todolist.service.authentication

import com.example.todolist.data.user.UserRepository
import com.example.todolist.security.JwtUtil
import com.example.todolist.security.PayloadToken
import com.example.todolist.utils.md5
import org.springframework.stereotype.Service

@Service
class AuthenticationServiceImpl(
        private val userRepository: UserRepository,
        private val jwtUtil: JwtUtil,
) : AuthentiationService {

    override fun doLogin(username: String, password: String): String {
        val user = userRepository.findByUsernameAndPassword(username, password.md5())
        val payloadToken = PayloadToken(userId = user.id)
        return jwtUtil.generateToken(payloadToken)
    }
}
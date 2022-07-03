package com.example.todolist.security

import com.example.todolist.response.ResponseModel
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthFilter(
        authenticationManager: AuthenticationManager,
        private val jwtUtil: JwtUtil,
) : BasicAuthenticationFilter(
        authenticationManager
) {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        try {
            val authorizationHeader = request.getHeader("Authorization")
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                val tokenHeader = authorizationHeader.substring(7)
                val auth = getAuthentication(tokenHeader)
                SecurityContextHolder.getContext().authentication = auth
            }
            chain.doFilter(request, response)
        } catch (e: AuthenticationException) {
            onUnsuccessfulAuthentication(request, response, e)
        }
    }

    private fun getAuthentication(tokenHeader: String): UsernamePasswordAuthenticationToken? {
        if (jwtUtil.isTokenValid(tokenHeader)) {
            val token = jwtUtil.getToken(tokenHeader)
            val payloadToken = jacksonObjectMapper().readValue(token, PayloadToken::class.java)
            return UsernamePasswordAuthenticationToken(payloadToken, null, null)
        } else {
            throw UsernameNotFoundException("Token Inválido")
        }
    }

    override fun onUnsuccessfulAuthentication(
            request: HttpServletRequest?,
            response: HttpServletResponse?,
            failed: AuthenticationException?
    ) {
        val err = ResponseModel<String>(null)
                .withHttpStatus(HttpStatus.UNAUTHORIZED)
                .withMessage(failed?.message.toString())
        val objectMapper = ObjectMapper()
        if (response != null) {
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = "application/json;charset=UTF-8"
            response.writer.append(objectMapper.writeValueAsString(err))
        }
    }
}
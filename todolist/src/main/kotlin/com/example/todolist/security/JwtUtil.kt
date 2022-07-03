package com.example.todolist.security

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    @Value("\${jwt.expiration-days}")
    private lateinit var expiration: String

    /**
     * Verifica a data do token
     * Compara a data do token com a data atual
     * Se for válido retorna true senão false
     *
     * @param token
     * @return Boolean
     */
    fun isTokenValid(token: String): Boolean {
        val claims = getClaimsToken(token)
        if (claims != null) {
            val dataToken = claims.subject
            val expirationDate = claims.expiration
            val now = Date(System.currentTimeMillis())
            if (dataToken != null && expirationDate != null && now.before(expirationDate)) {
                return true
            }
        }
        return false
    }

    /**
     * Aplica a chave secreta no token a fim de obter o subject
     * Neste caso o subject será um json que corresponde ao objeto [PayloadToken]
     *
     * @param token
     * @return Claims?
     */
    private fun getClaimsToken(token: String): Claims? {
        return try {
            Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(token).body
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Chama o método getClaimsToken
     * @see getClaimsToken
     *
     * Obtem o subject, que neste caso será o json que corresponde ao objeto [PayloadToken]
     *
     * @param token
     * @return String?
     */
    fun getToken(token: String): String? {
        val claims = getClaimsToken(token)
        return claims?.subject
    }

    /**
     * @param dataToken
     * @return String
     */
    fun generateToken(payloadToken: PayloadToken): String {
        val jsonString = jacksonObjectMapper().writeValueAsString(payloadToken)
        return Jwts.builder()
                .setSubject(jsonString)
                .setExpiration(Date(System.currentTimeMillis() + (24 * 3600000 * expiration.toLong())))
                .signWith(SignatureAlgorithm.HS512, secret.toByteArray())
                .compact()
    }
}
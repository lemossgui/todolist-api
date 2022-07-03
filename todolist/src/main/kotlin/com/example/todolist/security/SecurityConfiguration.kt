package com.example.todolist.security

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.web.cors.CorsConfiguration
import javax.servlet.http.HttpServletRequest

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
        private val jwtUtil: JwtUtil,
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.cors().configurationSource { _: HttpServletRequest? ->
            CorsConfiguration().apply {
                this.allowedOrigins = listOf("*")
                this.allowedMethods = listOf("*")
                this.allowedHeaders = listOf("*")
            }
        }

        http.headers().frameOptions {
            it.disable()
        }

        http.csrf().disable().authorizeRequests()

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/authentication").permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                /// Para que o swagger fique disponível publicamente
                .antMatchers(
                        "/admin/system/state/*",
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**"
                ).permitAll()
                .anyRequest()
                .authenticated()

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.addFilter(JwtAuthFilter(authenticationManager(), jwtUtil))
    }
}
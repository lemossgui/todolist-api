package com.example.todolist.controller.authentication

import com.example.todolist.response.ResponseModel
import com.example.todolist.service.authentication.AuthentiationService
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("authentication")
class AuthenticationController(
        private val service: AuthentiationService,
) {

    @PostMapping
    fun doLogin(@RequestBody credentials: CredendialsDto): ResponseEntity<ResponseModel<String>> {
        val result = service.doLogin(credentials.username, credentials.password)
        return ResponseModel(result)
                .withHttpStatus(HttpStatus.OK)
                .withMessage("Usuário autenticado com sucesso!")
                .build()
    }
}
package com.example.todolist.controller.authentication

import com.example.todolist.utils.NoArgs

@NoArgs
data class CredendialsDto(
        var username: String,
        var password: String,
)
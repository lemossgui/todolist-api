package com.example.todolist.controller.user

import com.example.todolist.utils.NoArgs

@NoArgs
data class UserEditDto(
        var id: Long,
        var name: String,
        var username: String,
)
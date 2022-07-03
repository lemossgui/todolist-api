package com.example.todolist.controller.user

import com.example.todolist.utils.NoArgs

@NoArgs
data class UserSaveDto(
        var name: String,
        var username: String,
        var password: String,
)
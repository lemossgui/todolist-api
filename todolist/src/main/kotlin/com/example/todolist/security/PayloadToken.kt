package com.example.todolist.security

import com.example.todolist.utils.NoArgs

@NoArgs
data class PayloadToken(
        var userId: Long,
)
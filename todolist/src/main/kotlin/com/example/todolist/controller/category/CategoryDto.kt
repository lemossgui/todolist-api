package com.example.todolist.controller.category

import com.example.todolist.utils.NoArgs

@NoArgs
data class CategoryDto(
        var id: Long,
        var description: String,
)
package com.example.todolist.controller.category

import com.example.todolist.utils.NoArgs

@NoArgs
data class CategorySaveDto(
        var id: Long,
        var description: String,
)
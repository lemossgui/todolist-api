package com.example.todolist.controller.task

import com.example.todolist.controller.category.CategoryDto
import com.example.todolist.utils.DATE_PATTERN
import com.example.todolist.utils.NoArgs
import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Timestamp

@NoArgs
data class TaskDto(
        var id: Long,
        var description: String,

        @JsonFormat(pattern = DATE_PATTERN)
        var datetime: Timestamp,
        var category: CategoryDto,
)
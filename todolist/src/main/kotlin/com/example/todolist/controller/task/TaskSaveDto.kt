package com.example.todolist.controller.task

import com.example.todolist.controller.simpleAssociation.SimpleAssociationDto
import com.example.todolist.utils.DATE_PATTERN
import com.example.todolist.utils.NoArgs
import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Timestamp

@NoArgs
data class TaskSaveDto(
        var description: String,

        @JsonFormat(pattern = DATE_PATTERN)
        var datetime: Timestamp,
        var category: SimpleAssociationDto,
)
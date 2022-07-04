package com.example.todolist.controller.task

import com.example.todolist.mapper.AbstractDtoMapperImpl
import com.example.todolist.service.task.TaskModel
import org.springframework.stereotype.Component

@Component
class TaskDtoMapper : AbstractDtoMapperImpl<TaskModel, TaskDto>(
        dtoClass = TaskDto::class.java,
)
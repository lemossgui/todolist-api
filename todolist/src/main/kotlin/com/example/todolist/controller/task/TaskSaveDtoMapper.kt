package com.example.todolist.controller.task

import com.example.todolist.mapper.AbstractSaveDtoMapperImpl
import com.example.todolist.service.task.TaskModel
import org.springframework.stereotype.Component

@Component
class TaskSaveDtoMapper : AbstractSaveDtoMapperImpl<TaskModel, TaskSaveDto>(
        modelClass = TaskModel::class.java,
)
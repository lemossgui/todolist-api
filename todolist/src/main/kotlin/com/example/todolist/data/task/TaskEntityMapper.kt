package com.example.todolist.data.task

import com.example.todolist.mapper.AbstractEntityMapperImpl
import com.example.todolist.service.task.TaskModel
import org.springframework.stereotype.Component

@Component
class TaskEntityMapper : AbstractEntityMapperImpl<TaskModel, TaskEntity>(
        modelClass = TaskModel::class.java,
        entityClass = TaskEntity::class.java,
)

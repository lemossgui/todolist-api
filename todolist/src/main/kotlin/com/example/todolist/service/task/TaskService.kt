package com.example.todolist.service.task

import com.example.todolist.data.task.TaskRepository
import com.example.todolist.service.abstractService.AbstractCrudServiceImpl
import org.springframework.stereotype.Service

@Service
abstract class TaskService(
        repository: TaskRepository,
) : AbstractCrudServiceImpl<TaskModel>(
        repository = repository,
)
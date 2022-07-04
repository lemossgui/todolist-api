package com.example.todolist.data.task

import com.example.todolist.data.abstractRepository.AbstractCrudRepositoryImpl
import com.example.todolist.service.task.TaskModel
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
abstract class TaskRepository(
        mapper: TaskEntityMapper,
        storage: TaskStorage,
) : AbstractCrudRepositoryImpl<TaskModel, TaskEntity>(
        mapper = mapper,
        storage = storage,
)
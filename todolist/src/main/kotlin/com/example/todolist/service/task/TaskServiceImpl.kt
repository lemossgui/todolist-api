package com.example.todolist.service.task

import com.example.todolist.data.task.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl(
        repository: TaskRepository,
) : TaskService(
        repository = repository,
) {

    override fun applyValuesForEdit(oldEntity: TaskModel, newEntity: TaskModel): TaskModel {
        oldEntity.description = newEntity.description
        oldEntity.datetime = newEntity.datetime
        oldEntity.category = newEntity.category
        return oldEntity
    }
}
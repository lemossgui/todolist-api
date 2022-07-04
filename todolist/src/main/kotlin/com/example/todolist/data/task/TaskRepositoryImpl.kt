package com.example.todolist.data.task

import org.springframework.stereotype.Repository

@Repository
class TaskRepositoryImpl(
        mapper: TaskEntityMapper,
        storage: TaskStorage,
) : TaskRepository(
        mapper = mapper,
        storage = storage,
)
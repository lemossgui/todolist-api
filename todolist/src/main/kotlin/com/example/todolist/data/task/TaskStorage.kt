package com.example.todolist.data.task

import org.springframework.data.jpa.repository.JpaRepository

interface TaskStorage : JpaRepository<TaskEntity, Long>
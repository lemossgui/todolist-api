package com.example.todolist.data.category

import org.springframework.data.jpa.repository.JpaRepository

interface CategoryStorage : JpaRepository<CategoryEntity, Long>
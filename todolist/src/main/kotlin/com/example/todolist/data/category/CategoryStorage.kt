package com.example.todolist.data.category

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CategoryStorage : JpaRepository<CategoryEntity, Long> {

    @Query("SELECT COUNT(e) > 0 " +
            "FROM CategoryEntity e " +
            "WHERE e.description = :description")
    fun existsByDescription(description: String): Boolean

    @Query("SELECT COUNT(e) > 0 " +
            "FROM CategoryEntity e " +
            "WHERE e.description = :description " +
            "AND e.id != :id")
    fun existsByDescriptionAndIdDiff(description: String, id: Long): Boolean
}
package com.example.todolist.data.category

import com.example.todolist.data.abstractEntity.AbstractEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "category", schema = "public")
data class CategoryEntity(
        var description: String,
) : AbstractEntity()
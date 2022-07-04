package com.example.todolist.data.task

import com.example.todolist.data.abstractEntity.AbstractEntity
import com.example.todolist.data.category.CategoryEntity
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "task", schema = "public")
data class TaskEntity(
        var description: String,
        var datetime: Timestamp,

        @ManyToOne
        @JoinColumn(name = "category_id", referencedColumnName = "id")
        var category: CategoryEntity,
) : AbstractEntity()
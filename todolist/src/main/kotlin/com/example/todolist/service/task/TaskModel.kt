package com.example.todolist.service.task

import com.example.todolist.service.abstractModel.AbstractModel
import com.example.todolist.service.category.CategoryModel
import com.example.todolist.utils.NoArgs
import java.sql.Timestamp

@NoArgs
data class TaskModel(
        var description: String,
        var datetime: Timestamp,
        var category: CategoryModel,
) : AbstractModel()
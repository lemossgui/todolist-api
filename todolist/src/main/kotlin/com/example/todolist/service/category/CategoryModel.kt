package com.example.todolist.service.category

import com.example.todolist.service.abstractModel.AbstractModel
import com.example.todolist.utils.NoArgs

@NoArgs
data class CategoryModel(
        var description: String,
) : AbstractModel()
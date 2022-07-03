package com.example.todolist.controller.category

import com.example.todolist.mapper.AbstractSaveDtoMapperImpl
import com.example.todolist.service.category.CategoryModel
import org.springframework.stereotype.Component

@Component
class CategorySaveDtoMapper : AbstractSaveDtoMapperImpl<CategoryModel, CategorySaveDto>(
        modelClass = CategoryModel::class.java,
)
package com.example.todolist.data.category

import com.example.todolist.mapper.AbstractEntityMapperImpl
import com.example.todolist.service.category.CategoryModel
import org.springframework.stereotype.Component

@Component
class CategoryEntityMapper : AbstractEntityMapperImpl<CategoryModel, CategoryEntity>(
        modelClass = CategoryModel::class.java,
        entityClass = CategoryEntity::class.java,
)
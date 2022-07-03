package com.example.todolist.controller.category

import com.example.todolist.mapper.AbstractDtoMapperImpl
import com.example.todolist.service.category.CategoryModel
import org.springframework.stereotype.Component

@Component
class CategoryDtoMapper : AbstractDtoMapperImpl<CategoryModel, CategoryDto>(
        dtoClass = CategoryDto::class.java,
)
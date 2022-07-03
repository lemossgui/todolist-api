package com.example.todolist.service.category

import com.example.todolist.data.category.CategoryRepository
import com.example.todolist.service.abstractService.AbstractCrudServiceImpl
import org.springframework.stereotype.Service

@Service
abstract class CategoryService(
        repository: CategoryRepository,
) : AbstractCrudServiceImpl<CategoryModel>(
        repository = repository,
)
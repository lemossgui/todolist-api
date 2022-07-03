package com.example.todolist.service.category

import com.example.todolist.data.category.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
        repository: CategoryRepository,
) : CategoryService(
        repository = repository,
) {

    override fun applyValuesForEdit(oldEntity: CategoryModel, newEntity: CategoryModel): CategoryModel {
        oldEntity.description = newEntity.description
        return oldEntity
    }
}
package com.example.todolist.data.category

import com.example.todolist.data.abstractRepository.AbstractCrudRepositoryImpl
import com.example.todolist.service.category.CategoryModel
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
abstract class CategoryRepository(
        mapper: CategoryEntityMapper,
        storage: CategoryStorage,
) : AbstractCrudRepositoryImpl<CategoryModel, CategoryEntity>(
        mapper = mapper,
        storage = storage,
) {
    abstract fun existsByDescription(description: String): Boolean
    abstract fun existsByDescriptionAndIdDiff(description: String, id: Long): Boolean
}
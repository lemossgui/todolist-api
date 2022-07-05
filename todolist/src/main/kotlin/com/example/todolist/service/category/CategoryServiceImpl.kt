package com.example.todolist.service.category

import com.example.todolist.controller.exception.DuplicateEntityException
import com.example.todolist.data.category.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
        private val repository: CategoryRepository,
) : CategoryService(
        repository = repository,
) {

    override fun save(model: CategoryModel): CategoryModel {
        if (repository.existsByDescription(model.description)) {
            throw DuplicateEntityException("Já existe uma categoria cadastrada com esta descrição")
        }
        return super.save(model)
    }

    override fun edit(id: Long, model: CategoryModel): CategoryModel {
        if (repository.existsByDescriptionAndIdDiff(model.description, id)) {
            throw DuplicateEntityException("Já existe uma categoria cadastrada com esta descrição")
        }
        return super.edit(id, model)
    }

    override fun applyValuesForEdit(oldEntity: CategoryModel, newEntity: CategoryModel): CategoryModel {
        oldEntity.description = newEntity.description
        return oldEntity
    }
}
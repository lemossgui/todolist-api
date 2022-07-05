package com.example.todolist.data.category

import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImpl(
        mapper: CategoryEntityMapper,
        private val storage: CategoryStorage,
) : CategoryRepository(
        mapper = mapper,
        storage = storage,
) {

    override fun existsByDescription(description: String): Boolean {
        return storage.existsByDescription(description)
    }

    override fun existsByDescriptionAndIdDiff(description: String, id: Long): Boolean {
        return storage.existsByDescriptionAndIdDiff(description, id)
    }
}
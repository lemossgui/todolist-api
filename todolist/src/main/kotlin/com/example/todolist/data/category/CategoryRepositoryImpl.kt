package com.example.todolist.data.category

import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImpl(
        mapper: CategoryEntityMapper,
        storage: CategoryStorage,
) : CategoryRepository(
        mapper = mapper,
        storage = storage,
)
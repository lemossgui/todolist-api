package com.example.todolist.controller.category

import com.example.todolist.controller.abstractController.AbstractCrudControllerImpl
import com.example.todolist.service.category.CategoryModel
import com.example.todolist.service.category.CategoryService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("category")
class CategoryController(
        service: CategoryService,
        mapper: CategoryDtoMapper,
        saveMapper: CategorySaveDtoMapper,
        editMapper: CategorySaveDtoMapper,
) : AbstractCrudControllerImpl<CategoryModel, CategoryDto, CategorySaveDto, CategorySaveDto>(
        service = service,
        mapper = mapper,
        saveMapper = saveMapper,
        editMapper = editMapper,
)
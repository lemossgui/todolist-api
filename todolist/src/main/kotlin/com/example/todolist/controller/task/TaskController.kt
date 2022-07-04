package com.example.todolist.controller.task

import com.example.todolist.controller.abstractController.AbstractCrudControllerImpl
import com.example.todolist.service.task.TaskModel
import com.example.todolist.service.task.TaskService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("task")
class TaskController(
        service: TaskService,
        mapper: TaskDtoMapper,
        saveMapper: TaskSaveDtoMapper,
        editMapper: TaskSaveDtoMapper,
) : AbstractCrudControllerImpl<TaskModel, TaskDto, TaskSaveDto, TaskSaveDto>(
        service = service,
        mapper = mapper,
        saveMapper = saveMapper,
        editMapper = editMapper,
)
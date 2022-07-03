package com.example.todolist.controller.user

import com.example.todolist.controller.abstractController.AbstractCrudControllerImpl
import com.example.todolist.service.user.UserModel
import com.example.todolist.service.user.UserService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("user")
class UserController(
        service: UserService,
        mapper: UserDtoMapper,
        saveMapper: UserSaveDtoMapper,
        editMapper: UserEditDtoMapper,
) : AbstractCrudControllerImpl<UserModel, UserDto, UserSaveDto, UserEditDto>(
        service = service,
        mapper = mapper,
        saveMapper = saveMapper,
        editMapper = editMapper,
)
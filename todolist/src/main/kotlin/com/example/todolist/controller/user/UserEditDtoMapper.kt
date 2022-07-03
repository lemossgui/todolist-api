package com.example.todolist.controller.user

import com.example.todolist.mapper.AbstractSaveDtoMapperImpl
import com.example.todolist.service.user.UserModel
import org.springframework.stereotype.Component

@Component
class UserEditDtoMapper : AbstractSaveDtoMapperImpl<UserModel, UserEditDto>(
        modelClass = UserModel::class.java,
)
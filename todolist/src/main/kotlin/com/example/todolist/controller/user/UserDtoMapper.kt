package com.example.todolist.controller.user

import com.example.todolist.mapper.AbstractDtoMapperImpl
import com.example.todolist.service.user.UserModel
import org.springframework.stereotype.Component

@Component
class UserDtoMapper : AbstractDtoMapperImpl<UserModel, UserDto>(
        dtoClass = UserDto::class.java,
)
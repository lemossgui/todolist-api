package com.example.todolist.data.user

import com.example.todolist.mapper.AbstractEntityMapperImpl
import com.example.todolist.service.user.UserModel
import org.springframework.stereotype.Component

@Component
class UserEntityMapper : AbstractEntityMapperImpl<UserModel, UserEntity>(
        modelClass = UserModel::class.java,
        entityClass = UserEntity::class.java,
)
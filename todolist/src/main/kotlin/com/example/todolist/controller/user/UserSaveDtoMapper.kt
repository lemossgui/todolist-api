package com.example.todolist.controller.user

import com.example.todolist.mapper.AbstractSaveDtoMapperImpl
import com.example.todolist.service.user.UserModel
import com.example.todolist.utils.md5
import org.springframework.stereotype.Component

@Component
class UserSaveDtoMapper : AbstractSaveDtoMapperImpl<UserModel, UserSaveDto>(
        modelClass = UserModel::class.java,
) {

    override fun mapToModel(dto: UserSaveDto): UserModel {
        return UserModel(
                name = dto.name,
                username = dto.username,
                password = dto.password.md5()
        )
    }
}
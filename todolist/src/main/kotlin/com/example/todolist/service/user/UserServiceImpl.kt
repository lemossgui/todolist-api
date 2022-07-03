package com.example.todolist.service.user

import com.example.todolist.data.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        repository: UserRepository,
) : UserService(
        repository = repository,
) {
    override fun applyValuesForEdit(oldEntity: UserModel, newEntity: UserModel): UserModel {
        oldEntity.name = newEntity.name
        oldEntity.username = newEntity.username
        return oldEntity
    }
}
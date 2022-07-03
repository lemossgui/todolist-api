package com.example.todolist.service.user

import com.example.todolist.data.user.UserRepository
import com.example.todolist.service.abstractService.AbstractCrudServiceImpl
import org.springframework.stereotype.Service

@Service
abstract class UserService(
        repository: UserRepository,
) : AbstractCrudServiceImpl<UserModel>(
        repository = repository,
) {
}
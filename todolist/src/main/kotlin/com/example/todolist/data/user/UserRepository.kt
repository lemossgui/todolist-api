package com.example.todolist.data.user

import com.example.todolist.data.abstractRepository.AbstractCrudRepositoryImpl
import com.example.todolist.service.user.UserModel
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
abstract class UserRepository(
        mapper: UserEntityMapper,
        storage: UserStorage,
) : AbstractCrudRepositoryImpl<UserModel, UserEntity>(
        mapper = mapper,
        storage = storage,
) {
    abstract fun findByUsernameAndPassword(username: String, password: String): UserModel
}
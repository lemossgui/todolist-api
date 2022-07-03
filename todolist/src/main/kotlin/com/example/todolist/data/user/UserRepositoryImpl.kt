package com.example.todolist.data.user

import com.example.todolist.controller.exception.NotFoundException
import com.example.todolist.service.user.UserModel
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
        private val mapper: UserEntityMapper,
        private val storage: UserStorage,
) : UserRepository(
        mapper = mapper,
        storage = storage,
) {

    override fun findByUsernameAndPassword(username: String, password: String): UserModel {
        val found = storage.findByUsernameAndPassword(username, password)
        if (found.isPresent) return mapper.mapToModel(found.get())
        else throw NotFoundException("Usuário não encontrado. Nome de usuário ou senha incorretos")
    }
}
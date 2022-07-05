package com.example.todolist.service.user

import com.example.todolist.controller.exception.DuplicateEntityException
import com.example.todolist.data.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        private val repository: UserRepository,
) : UserService(
        repository = repository,
) {

    override fun save(model: UserModel): UserModel {
        if (repository.existsByUsername(model.username)) {
            throw DuplicateEntityException("Já existe um usuário cadastrado com este username")
        }
        return super.save(model)
    }

    override fun edit(id: Long, model: UserModel): UserModel {
        if (repository.existsByUsernameAndIdDiff(model.username, id)) {
            throw DuplicateEntityException("Já existe um usuário cadastrado com este username")
        }
        return super.edit(id, model)
    }

    override fun applyValuesForEdit(oldEntity: UserModel, newEntity: UserModel): UserModel {
        oldEntity.name = newEntity.name
        oldEntity.username = newEntity.username
        return oldEntity
    }
}
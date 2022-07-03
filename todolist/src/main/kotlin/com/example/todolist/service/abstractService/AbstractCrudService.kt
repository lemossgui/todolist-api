package com.example.todolist.service.abstractService

import com.example.todolist.service.abstractModel.AbstractModel

interface AbstractCrudService<M : AbstractModel> {
    fun save(model: M): M
    fun edit(id: Long, model: M): M
    fun findById(id: Long): M
    fun findAll(): List<M>
    fun delete(id: Long): M
}
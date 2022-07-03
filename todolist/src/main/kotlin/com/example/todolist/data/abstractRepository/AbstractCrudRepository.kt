package com.example.todolist.data.abstractRepository

import com.example.todolist.service.abstractModel.AbstractModel

abstract class AbstractCrudRepository<M : AbstractModel> {
    abstract fun save(model: M): M
    abstract fun edit(id: Long, model: M): M
    abstract fun findById(id: Long): M
    abstract fun findAll(): List<M>
    abstract fun delete(id: Long): M
}
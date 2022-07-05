package com.example.todolist.service.abstractService

import com.example.todolist.data.abstractRepository.AbstractCrudRepository
import com.example.todolist.service.abstractModel.AbstractModel

abstract class AbstractCrudServiceImpl<M : AbstractModel>(
        private val repository: AbstractCrudRepository<M>,
) : AbstractCrudService<M> {

    override fun save(model: M): M {
        return repository.save(model)
    }

    override fun edit(id: Long, model: M): M {
        val oldEntity = findById(id)
        val entityForEdit = applyValuesForEdit(oldEntity, model)
        return repository.edit(id, entityForEdit)
    }

    override fun findById(id: Long): M {
        return repository.findById(id)
    }

    override fun findAll(): List<M> {
        return repository.findAll()
    }

    override fun delete(id: Long): M {
        return repository.delete(id)
    }

    abstract fun applyValuesForEdit(oldEntity: M, newEntity: M): M
}
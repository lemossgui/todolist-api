package com.example.todolist.data.abstractRepository

import com.example.todolist.controller.exception.NotFoundException
import com.example.todolist.data.abstractEntity.AbstractEntity
import com.example.todolist.mapper.AbstractEntityMapperImpl
import com.example.todolist.service.abstractModel.AbstractModel
import org.springframework.data.jpa.repository.JpaRepository

abstract class AbstractCrudRepositoryImpl<M : AbstractModel, E : AbstractEntity>(
        private val mapper: AbstractEntityMapperImpl<M, E>,
        private val storage: JpaRepository<E, Long>,
) : AbstractCrudRepository<M>() {

    override fun save(model: M): M {
        val entity = mapper.mapToEntity(model)
        val savedEntity = storage.save(entity)
        return mapper.mapToModel(savedEntity)
    }

    override fun edit(id: Long, model: M): M {
        val entity = mapper.mapToEntity(model)
        val savedEntity = storage.save(entity)
        return mapper.mapToModel(savedEntity)
    }

    override fun findById(id: Long): M {
        val found = storage.findById(id)
        return if (found.isPresent) mapper.mapToModel(found.get())
        else throw NotFoundException("Entidade não encontrada")
    }

    override fun findAll(): List<M> {
        val list = storage.findAll()
        return mapper.mapToListModel(list)
    }

    override fun delete(id: Long): M {
        val found = storage.findById(id)
        if (found.isPresent) {
            val entity = found.get()
            storage.deleteById(id)
            return mapper.mapToModel(entity)
        } else throw NotFoundException("Entidade não encontrada")
    }
}
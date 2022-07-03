package com.example.todolist.mapper

import com.example.todolist.data.abstractEntity.AbstractEntity
import com.example.todolist.service.abstractModel.AbstractModel
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractEntityMapperImpl<M : AbstractModel, E : AbstractEntity>(
        private val modelClass: Class<M>,
        private val entityClass: Class<E>,
) : AbstractEntityMapper<M, E> {

    @Autowired
    lateinit var objectMapperUtils: ObjectMapperUtils
    override fun mapToEntity(model: M): E {
        return objectMapperUtils.map(model, entityClass)
    }

    override fun mapToModel(entity: E): M {
        return objectMapperUtils.map(entity, modelClass)
    }

    fun mapToListEntity(list: List<M>): List<E> {
        return list.map(::mapToEntity)
    }

    fun mapToListModel(list: List<E>): List<M> {
        return list.map(::mapToModel)
    }
}
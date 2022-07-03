package com.example.todolist.mapper

import com.example.todolist.data.abstractEntity.AbstractEntity
import com.example.todolist.service.abstractModel.AbstractModel

interface AbstractEntityMapper<M : AbstractModel, E : AbstractEntity> {
    fun mapToEntity(model: M): E
    fun mapToModel(entity: E): M
}
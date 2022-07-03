package com.example.todolist.mapper

import com.example.todolist.service.abstractModel.AbstractModel
import javax.persistence.MappedSuperclass

@MappedSuperclass
interface AbstractDtoMapper<M : AbstractModel, D> {
    fun mapToDto(model: M): D
}
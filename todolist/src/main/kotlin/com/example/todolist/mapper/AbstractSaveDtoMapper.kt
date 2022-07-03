package com.example.todolist.mapper

import com.example.todolist.service.abstractModel.AbstractModel

interface AbstractSaveDtoMapper<M : AbstractModel, D> {
    fun mapToModel(dto: D): M
}
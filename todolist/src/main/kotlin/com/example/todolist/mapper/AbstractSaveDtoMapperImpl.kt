package com.example.todolist.mapper

import com.example.todolist.service.abstractModel.AbstractModel
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractSaveDtoMapperImpl<M : AbstractModel, D>(
        private val modelClass: Class<M>,
) : AbstractSaveDtoMapper<M, D> {

    @Autowired
    lateinit var objectMapperUtils: ObjectMapperUtils

    override fun mapToModel(dto: D): M {
        return objectMapperUtils.map(dto, modelClass)
    }

    fun mapToListModel(list: List<D>): List<M> {
        return list.map(::mapToModel)
    }
}
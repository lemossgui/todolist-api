package com.example.todolist.mapper

import com.example.todolist.service.abstractModel.AbstractModel
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractDtoMapperImpl<M : AbstractModel, D>(
        private val dtoClass: Class<D>,
) : AbstractDtoMapper<M, D> {

    @Autowired
    lateinit var objectMapperUtils: ObjectMapperUtils

    override fun mapToDto(model: M): D {
        return objectMapperUtils.map(model, dtoClass)
    }

    fun mapToListDto(list: List<M>): List<D> {
        return list.map(::mapToDto)
    }
}
package com.example.todolist.controller.simpleAssociation

import com.example.todolist.mapper.AbstractDtoMapperImpl
import com.example.todolist.service.abstractModel.AbstractModel
import org.springframework.stereotype.Component

@Component
class SimpleAssociationDtoMapper<M : AbstractModel> : AbstractDtoMapperImpl<M, SimpleAssociationDto>(
        dtoClass = SimpleAssociationDto::class.java,
)
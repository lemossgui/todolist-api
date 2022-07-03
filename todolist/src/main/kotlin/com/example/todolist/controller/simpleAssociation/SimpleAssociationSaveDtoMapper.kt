package com.example.todolist.controller.simpleAssociation

import com.example.todolist.mapper.AbstractSaveDtoMapperImpl
import com.example.todolist.service.abstractModel.AbstractModel
import org.springframework.stereotype.Component

@Component
class SimpleAssociationSaveDtoMapper<M : AbstractModel>(
        modelClass: Class<M>,
) : AbstractSaveDtoMapperImpl<M, SimpleAssociationDto>(
        modelClass = modelClass,
)
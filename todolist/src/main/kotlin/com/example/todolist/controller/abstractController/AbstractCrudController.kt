package com.example.todolist.controller.abstractController

import com.example.todolist.controller.simpleAssociation.SimpleAssociationDto
import com.example.todolist.response.ResponseModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

interface AbstractCrudController<Dto, SaveDto, EditDto> {
    fun save(@RequestBody dto: SaveDto): ResponseEntity<ResponseModel<SimpleAssociationDto>>
    fun edit(@PathVariable id: Long, @RequestBody dto: EditDto): ResponseEntity<ResponseModel<SimpleAssociationDto>>
    fun findById(@PathVariable id: Long): ResponseEntity<ResponseModel<Dto>>
    fun findAll(): ResponseEntity<ResponseModel<List<Dto>>>
    fun delete(@PathVariable id: Long): ResponseEntity<ResponseModel<SimpleAssociationDto>>
}
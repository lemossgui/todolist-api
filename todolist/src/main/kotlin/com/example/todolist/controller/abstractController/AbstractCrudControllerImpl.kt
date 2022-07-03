package com.example.todolist.controller.abstractController

import com.example.todolist.controller.simpleAssociation.SimpleAssociationDto
import com.example.todolist.controller.simpleAssociation.SimpleAssociationDtoMapper
import com.example.todolist.mapper.AbstractDtoMapperImpl
import com.example.todolist.mapper.AbstractSaveDtoMapperImpl
import com.example.todolist.response.ResponseModel
import com.example.todolist.service.abstractModel.AbstractModel
import com.example.todolist.service.abstractService.AbstractCrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

abstract class AbstractCrudControllerImpl<
        M : AbstractModel,
        Dto,
        SaveDto,
        EditDto>(
        var service: AbstractCrudService<M>,
        var mapper: AbstractDtoMapperImpl<M, Dto>,
        var saveMapper: AbstractSaveDtoMapperImpl<M, SaveDto>,
        var editMapper: AbstractSaveDtoMapperImpl<M, EditDto>,
) : AbstractCrudController<Dto, SaveDto, EditDto> {

    @Autowired
    lateinit var simpleAssociationMapper: SimpleAssociationDtoMapper<M>

    @PostMapping
    override fun save(@RequestBody dto: SaveDto): ResponseEntity<ResponseModel<SimpleAssociationDto>> {
        val model = saveMapper.mapToModel(dto)
        val result = service.save(model)
        return ResponseModel(simpleAssociationMapper.mapToDto(result))
                .withHttpStatus(HttpStatus.CREATED)
                .withMessage("Entidade criada com sucesso!")
                .build()
    }

    @PutMapping("{id}")
    override fun edit(@PathVariable id: Long, @RequestBody dto: EditDto): ResponseEntity<ResponseModel<SimpleAssociationDto>> {
        val model = editMapper.mapToModel(dto)
        val result = service.edit(id, model)
        return ResponseModel(simpleAssociationMapper.mapToDto(result))
                .withHttpStatus(HttpStatus.OK)
                .withMessage("Entidade editada com sucesso!")
                .build()
    }

    @GetMapping("{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<ResponseModel<Dto>> {
        val result = service.findById(id)
        return ResponseModel(mapper.mapToDto(result))
                .withHttpStatus(HttpStatus.OK)
                .withMessage("Entidade obtida com sucesso!")
                .build()
    }

    @GetMapping
    override fun findAll(): ResponseEntity<ResponseModel<List<Dto>>> {
        val result = service.findAll()
        return ResponseModel(mapper.mapToListDto(result))
                .withHttpStatus(HttpStatus.OK)
                .withMessage("Entidades obtidas com sucesso!")
                .build()
    }

    @DeleteMapping("{id}")
    override fun delete(@PathVariable id: Long): ResponseEntity<ResponseModel<SimpleAssociationDto>> {
        val result = service.delete(id)
        return ResponseModel(simpleAssociationMapper.mapToDto(result))
                .withHttpStatus(HttpStatus.OK)
                .withMessage("Entidade deletada com sucesso!")
                .build()
    }
}
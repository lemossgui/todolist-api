package com.example.todolist.service.abstractModel

import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractModel {
    open var id: Long = 0
}
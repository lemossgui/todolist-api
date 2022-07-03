package com.example.todolist.data.abstractEntity

import javax.persistence.*

@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0
}
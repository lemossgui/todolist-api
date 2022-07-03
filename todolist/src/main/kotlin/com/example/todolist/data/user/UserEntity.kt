package com.example.todolist.data.user

import com.example.todolist.data.abstractEntity.AbstractEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user", schema = "public")
data class UserEntity(
        var name: String,
        var username: String,
        var password: String,
) : AbstractEntity()
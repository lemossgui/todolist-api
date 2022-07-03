package com.example.todolist.service.user

import com.example.todolist.service.abstractModel.AbstractModel
import com.example.todolist.utils.NoArgs

@NoArgs
data class UserModel(
        var name: String,
        var username: String,
        var password: String,
) : AbstractModel()
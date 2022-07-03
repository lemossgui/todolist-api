package com.example.todolist.controller.exception

class NotFoundException(msg: String? = "A entidade não foi encontrada") : RuntimeException(msg)
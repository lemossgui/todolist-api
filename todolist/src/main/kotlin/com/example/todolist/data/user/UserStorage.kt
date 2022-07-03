package com.example.todolist.data.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface UserStorage : JpaRepository<UserEntity, Long> {

    @Query("SELECT u " +
            "FROM UserEntity u " +
            "WHERE u.username = :username " +
            "AND u.password = :password")
    fun findByUsernameAndPassword(username: String, password: String): Optional<UserEntity>
}
package com.gugujeoljeol.app.domain

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column


object Users : IntIdTable("user_info", "id") {
    val email: Column<String> = varchar("email", 30)
    val password: Column<String> = varchar("password", 12)
    val nickname: Column<String> = varchar("nickname", 12)
}

class User(id: EntityID<Int>) : IntEntity(id) {
    val email: String by Users.email
    val password: String by Users.password
    val nickname: String by Users.nickname

    companion object : IntEntityClass<User>(Users)
}

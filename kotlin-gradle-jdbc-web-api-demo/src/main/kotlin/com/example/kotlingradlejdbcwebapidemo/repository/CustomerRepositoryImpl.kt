package com.example.kotlingradlejdbcwebapidemo.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CustomerRepositoryImpl (val jdbcTemplate: JdbcTemplate): CustomerRepository{
    override fun add(firstName: String, lastName: String) {
        val sql = "INSERT INTO customer(firstName, lastName) VALUES (?, ?);"
        jdbcTemplate.update(sql, firstName, lastName)
        return
    }
}
package com.example.kotlingradlejdbcwebapidemo.repository

interface CustomerRepository {
    fun add(firstName: String, lastName: String)
}
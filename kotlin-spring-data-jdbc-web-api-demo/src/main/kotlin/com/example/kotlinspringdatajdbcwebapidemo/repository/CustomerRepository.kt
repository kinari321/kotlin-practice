package com.example.kotlinspringdatajdbcwebapidemo.repository

import com.example.kotlinspringdatajdbcwebapidemo.entity.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Int>

package com.example.kotlinspringdatajdbcwebapidemo.controller

import com.example.kotlinspringdatajdbcwebapidemo.entity.Customer
import com.example.kotlinspringdatajdbcwebapidemo.repository.CustomerRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(private val customerRepository: CustomerRepository) {
    @GetMapping("/customers/{id}")
    fun getById(@PathVariable id: Int) = customerRepository.findById(id)

    @GetMapping("/customers")
    fun getList(): MutableIterable<Customer> = customerRepository.findAll()

    @PostMapping("/customers")
    fun insert(@RequestBody customer: Customer) = customerRepository.save(customer)

    @DeleteMapping("/customers/{id}")
    fun delete(@PathVariable id: Int) = customerRepository.deleteById(id)
}

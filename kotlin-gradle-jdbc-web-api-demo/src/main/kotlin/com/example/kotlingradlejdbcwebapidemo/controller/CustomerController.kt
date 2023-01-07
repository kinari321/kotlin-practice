package com.example.kotlingradlejdbcwebapidemo.controller

import com.example.kotlingradlejdbcwebapidemo.service.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Suppress("unused")
class CustomerController(val customerService: CustomerService){
    @PostMapping("/customers")
    fun insert(@RequestBody request: CustomerInsertRequest): String{
        customerService.insertCustomer(request.firstName,request.lastName)
        return """
            {
                "message": "success
            }
        """.trimIndent()
    }
}
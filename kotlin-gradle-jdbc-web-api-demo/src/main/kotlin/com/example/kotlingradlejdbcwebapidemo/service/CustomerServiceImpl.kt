package com.example.kotlingradlejdbcwebapidemo.service

import com.example.kotlingradlejdbcwebapidemo.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerServiceImpl(val customerRepository: CustomerRepository) : CustomerService {
    @Transactional
    override fun insertCustomer(firstName: String, lastName: String) {
        customerRepository.add(firstName, lastName)
        return
    }
}

package com.example.kotlingradlejdbcwebapidemo.repository

import com.example.kotlingradlejdbcwebapidemo.model.Customer
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class CustomerRpwMapper : RowMapper<Customer> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Customer? {
        return Customer(
            rs.getLong("id"),
            rs.getString("first_name"),
            rs.getString("last_name")
        )
    }
}
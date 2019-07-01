package com.example.testRestAPI

import org.springframework.data.repository.CrudRepository

open interface CustomerRepository : CrudRepository<Customer, Long> {
    
    fun findByLastName(lastName: String): List<Customer>
}
package com.example.testRestAPI

import org.springframework.web.bind.annotation.*

@RestController
class CustomerController (val repository: CustomerRepository) {

    @GetMapping("/customers")
    fun getAll(): Iterable<Customer> = repository.findAll()

    @GetMapping("/customers/{id}")
    fun getById(@PathVariable id: Long) = repository.findById(id)

    @GetMapping("/customers/{lastName}")
    fun getByLastName(@RequestParam(value="lastName") lastName: String) = repository.findByLastName(lastName)
}
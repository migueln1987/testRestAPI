package com.example.testRestAPI

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Customer(
        val firstName: String,
        val lastName: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = -1
) {
    override fun toString(): String = 
    "Customer[id=${id}, firstName=${firstName}, lastName=${lastName}"
}
package com.example.testRestAPI

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean

@SpringBootApplication
class TestRestApiApplication : SpringBootServletInitializer() {
	val log: Logger = LoggerFactory.getLogger(TestRestApiApplication::class.java)

	override fun configure(builder: SpringApplicationBuilder?): SpringApplicationBuilder =
			builder!!.sources(TestRestApiApplication::class.java)

	@Bean
	fun demo(repository: CustomerRepository): CommandLineRunner {
		return CommandLineRunner { _ ->
			// save a couple of customers
			repository.save(Customer("Jack", "Bauer"))
			repository.save(Customer("Chloe", "O'Brian"))
			repository.save(Customer("Kim", "Bauer"))
			repository.save(Customer("David", "Palmer"))
			repository.save(Customer("Michelle", "Dessler"))

			log.info("Customers found with findAll()")
			log.info("------------------------------")
			// val allCustomers = repository.findAll()
			for(customer in repository.findAll()) {
				log.info(customer.toString())
			}
			log.info("")

			// fetch an individual customer by ID
			repository.findById(1L).ifPresent{customer ->
				log.info("Customer found with findById(1L):")
				log.info("---------------------------------")
				log.info(customer.toString())
				log.info("")
			}

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):")
			log.info("--------------------------------------------")
			repository.findByLastName("Bauer").forEach { bauer ->
				log.info(bauer.toString())
			}
			log.info("")
		}
	}
}

fun main(args: Array<String>) {
	runApplication<TestRestApiApplication>(*args)
}

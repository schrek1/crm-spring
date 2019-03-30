package cz.schrek.spring.mvc.crm.service

import cz.schrek.spring.mvc.crm.entity.Customer

interface CustomerService {

    fun getCustomers(): List<Customer>

    fun saveCustomer(customer: Customer)

    fun getCustomer(customerId: Int): Customer?

    fun deleteCustomer(customerId: Int)

    fun searchCustomer(searchText: String): List<Customer>

}
package cz.schrek.spring.mvc.crm.dao

import cz.schrek.spring.mvc.crm.entity.Customer

interface CustomerDAO {

    fun getCustomers(): List<Customer>

    fun saveCustomer(customer: Customer)

    fun getCustomer(customerId: Int): Customer?

    fun deleteCustomer(customerId: Int)
}
package cz.schrek.spring.mvc.crm.dao

import cz.schrek.spring.mvc.crm.entity.Customer

interface CustomerDAO {

    fun getCustomers(): List<Customer>

}
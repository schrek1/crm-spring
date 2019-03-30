package cz.schrek.spring.mvc.crm.service.impl

import cz.schrek.spring.mvc.crm.dao.CustomerDAO
import cz.schrek.spring.mvc.crm.entity.Customer
import cz.schrek.spring.mvc.crm.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
open class CustomerServiceImpl : CustomerService {
    @Autowired
    private lateinit var customerDAO: CustomerDAO

    @Transactional
    override fun getCustomers() = customerDAO.getCustomers()

    @Transactional
    override fun saveCustomer(customer: Customer) = customerDAO.saveCustomer(customer)

    @Transactional
    override fun getCustomer(customerId: Int) = customerDAO.getCustomer(customerId)

    @Transactional
    override fun deleteCustomer(customerId: Int) = customerDAO.deleteCustomer(customerId)

    @Transactional
    override fun searchCustomer(searchText: String) =
        customerDAO.getCustomerByFirstName(searchText).union(
            customerDAO.getCustomerByEmail(searchText)
        ).union(
            customerDAO.getCustomerByLastName(searchText)
        ).toList()


}

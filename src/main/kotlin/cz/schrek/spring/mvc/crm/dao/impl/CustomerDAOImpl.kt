package cz.schrek.spring.mvc.crm.dao.impl

import cz.schrek.spring.mvc.crm.dao.CustomerDAO
import cz.schrek.spring.mvc.crm.entity.Customer
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
open class CustomerDAOImpl : CustomerDAO {

    @Autowired
    private lateinit var sessionFactory: SessionFactory

    override fun getCustomers(): List<Customer> {
        sessionFactory.currentSession?.apply {
            createQuery("from Customer order by lastName", Customer::class.java)?.apply {
                return resultList
            }
        }
        return emptyList()
    }

    override fun saveCustomer(customer: Customer) {
        sessionFactory.currentSession?.apply {
            save(customer)
        }
    }

}
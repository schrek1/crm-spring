package cz.schrek.spring.mvc.crm.dao.impl

import cz.schrek.spring.mvc.crm.dao.CustomerDAO
import cz.schrek.spring.mvc.crm.entity.Customer
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
open class CustomerDAOImpl : CustomerDAO {

    @Autowired
    private lateinit var sessionFactory: SessionFactory

    private val clazz = Customer::class.java

    override fun getCustomers() = sessionFactory.currentSession?.run {
        createQuery("from Customer order by lastName", clazz)?.run {
            resultList.toList()
        }
    } ?: emptyList()


    override fun saveCustomer(customer: Customer) {
        sessionFactory.currentSession?.apply {
            saveOrUpdate(customer)
        }
    }


    override fun getCustomer(customerId: Int) = sessionFactory.currentSession?.run {
        get(clazz, customerId)
    }

    override fun deleteCustomer(customerId: Int) {
        sessionFactory.currentSession?.apply {
            createQuery("delete from Customer where id=:customerId").apply {
                setParameter("customerId", customerId)
                executeUpdate()
            }
        }
    }

    override fun getCustomersByFirstName(searchText: String) = sessionFactory.currentSession?.run {
        createQuery(
            "from Customer where firstName like :searchText or lower(firstName) like :searchText order by lastName",
            clazz
        )?.run {
            setParameter("searchText", "%$searchText%")
            list()?.toList()
        }
    } ?: emptyList<Customer>()

    override fun getCustomersByEmail(searchText: String) = sessionFactory.currentSession?.run {
        createQuery(
            "from Customer where email like :searchText or lower(email) like :searchText order by lastName",
            clazz
        )?.run {
            setParameter("searchText", "%$searchText%")
            list()?.toList()
        }
    } ?: emptyList<Customer>()

    override fun getCustomersByLastName(searchText: String) = sessionFactory.currentSession?.run {
        createQuery(
            "from Customer where lastName like :searchText or lower(lastName) like :searchText order by lastName",
            clazz
        )?.run {
            setParameter("searchText", "%$searchText%")
            list()?.toList()
        }
    } ?: emptyList<Customer>()

    override fun getCustomersByFullTextSearch(searchText: String): List<Customer> = sessionFactory.currentSession?.run {
        createQuery(
            "from Customer where " +
                    "firstName like :searchText or lower(firstName) like :searchText or " +
                    "lastName like :searchText or lower(lastName) like :searchText or " +
                    "email like :searchText or lower(email) like :searchText " +
                    "order by lastName",
            clazz
        )?.run {
            setParameter("searchText", "%$searchText%")
            list()?.toList()
        }
    } ?: emptyList<Customer>()
}
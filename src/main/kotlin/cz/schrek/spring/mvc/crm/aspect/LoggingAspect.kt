package cz.schrek.spring.mvc.crm.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingAspect {

    @Before("execution(* cz.schrek.spring.mvc.crm.dao.CustomerDAO.getCustomers())")
    fun beforeGetUsers() {
        println("\n=====>> Executing @Before advice on getCustomers()")
    }

    @Before("execution(cz.schrek.spring.mvc.crm.entity.Customer cz.schrek.spring.mvc.crm.dao.*.*(..))")
    fun beforeCustomerDAOOperation() {
        println("\n=====>> Executing @Before advice on CustomerDAO action which return Customer")
    }
}
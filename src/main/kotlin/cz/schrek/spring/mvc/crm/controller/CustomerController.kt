package cz.schrek.spring.mvc.crm.controller

import cz.schrek.spring.mvc.crm.dao.CustomerDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private lateinit var customerDAO: CustomerDAO

    @RequestMapping("/list")
    fun listCustomers(model: Model): String {
        model.addAttribute("customers", customerDAO.getCustomers())
        return "list-customer"
    }
}
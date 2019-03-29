package cz.schrek.spring.mvc.crm.controller

import cz.schrek.spring.mvc.crm.entity.Customer
import cz.schrek.spring.mvc.crm.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/list")
    fun listCustomers(model: Model): String {
        model.addAttribute("customers", customerService.getCustomers())
        return "list-customer"
    }

    @GetMapping("/showFormForAdd")
    fun showFormForAdd(model: Model): String {
        model.addAttribute("customer", Customer())
        return "customer-form"
    }

    @PostMapping("/saveCustomer")
    fun saveCustomer(@ModelAttribute("customer") customer: Customer): String {
        customerService.saveCustomer(customer)
        return "redirect:/customer/list"
    }
}
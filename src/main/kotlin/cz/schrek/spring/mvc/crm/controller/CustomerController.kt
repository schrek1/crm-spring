package cz.schrek.spring.mvc.crm.controller

import cz.schrek.spring.mvc.crm.entity.Customer
import cz.schrek.spring.mvc.crm.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/list")
    fun listCustomers(model: Model) = run {
        model.addAttribute("customers", customerService.getCustomers())
        "list-customer"
    }

    @GetMapping("/showFormForAdd")
    fun showFormForAdd(model: Model) = run {
        model.addAttribute("customer", Customer())
        "customer-form"
    }

    @PostMapping("/saveCustomer")
    fun saveCustomer(@ModelAttribute("customer") customer: Customer) = run {
        customerService.saveCustomer(customer)
        "redirect:/customer/list"
    }

    @GetMapping("/showFormForUpdate")
    fun showFormForUpdate(@RequestParam("customerId") customerId: Int, model: Model) =
        customerService.getCustomer(customerId)?.let {
            model.addAttribute("customer", it)
            "customer-form"
        }
            ?: "redirect:/customer/list"

    @GetMapping("/delete")
    fun deleteCustomer(@RequestParam("customerId") customerId: Int) = run {
        customerService.deleteCustomer(customerId)
        "redirect:/customer/list"
    }
}
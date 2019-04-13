package cz.schrek.spring.mvc.crm.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class LoginController {

    @GetMapping("/login")
    fun login(): String {
        val authentication = SecurityContextHolder.getContext().authentication

        return if (authentication.isAuthenticated) {
            "login-form"
        } else {
            "redirect:/customer/list"
        }
    }
}
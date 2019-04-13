package cz.schrek.spring.mvc.crm.controller

import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class LoginController {

    @GetMapping("/login")
    fun login(): String {
        val authentication = SecurityContextHolder.getContext().authentication

        return if (
            authentication != null
            && authentication !is AnonymousAuthenticationToken
            && authentication.isAuthenticated
        ) {
            "redirect:/customer/list"
        } else {
            "login-form"
        }
    }
}
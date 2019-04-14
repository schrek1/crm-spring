package cz.schrek.spring.mvc.crm.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AppController {

    @GetMapping("/admin")
    fun showAdminConsole() = "admin-page"

    @GetMapping("/manager")
    fun showManagerDashboard() = "manager-page"

    @GetMapping("/access-denied")
    fun showAccessDenied() = "access-denied"
}
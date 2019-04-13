package cz.schrek.spring.mvc.crm.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/processLogin")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        // add our users for in memory authentication
        val users = User.withDefaultPasswordEncoder()

        auth.inMemoryAuthentication()
            .withUser(users.username("novak").password("123").roles("EMPLOYEE"))
            .withUser(users.username("plasil").password("123").roles("MANAGER"))
            .withUser(users.username("admin").password("123").roles("ADMIN"))
    }

}







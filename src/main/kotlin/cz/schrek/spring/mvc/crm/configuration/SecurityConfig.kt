package cz.schrek.spring.mvc.crm.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import javax.sql.DataSource


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val dataSource: DataSource
) : WebSecurityConfigurerAdapter() {


    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests()
            .antMatchers("/customer/**").hasAuthority("EMPLOYEE")
            .antMatchers("/admin/**").hasAuthority("ADMIN")
            .antMatchers("/manager/**").hasAuthority("MANAGER")
            .and()
            .formLogin().loginPage("/login").loginProcessingUrl("/processLogin").permitAll()
            .and()
            .logout().logoutUrl("/logout").permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/access-denied")
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(
                "SELECT username, password, enabled " +
                        "FROM user " +
                        "WHERE username = ?"
            )
            .authoritiesByUsernameQuery(
                "SELECT username, authority " +
                        "FROM user_authority " +
                        "WHERE username = ?"
            )
    }
}







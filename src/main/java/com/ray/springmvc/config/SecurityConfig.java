package com.ray.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication().withUser(users
                .username("ray")
                .password("password")
                .roles("EMPLOYEE","ADMIN"));

        auth.inMemoryAuthentication().withUser(users
                .username("tommy")
                .password("password")
                .roles("EMPLOYEE"));
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                    // any request must be authenticated (must be logged in)
                    .antMatchers("/resources/css/**").permitAll()
                    .antMatchers("/customer/**").hasRole("EMPLOYEE")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    // comment out because only users have role can access.
                    //.anyRequest().authenticated()
                .and()
                .formLogin()
                    // URL for custom login page
                    // must use field name "username" and "password"
                    .loginPage("/showMyLoginPage")
                    // Spring Security provides by default (no code require)
                    .loginProcessingUrl("/authenticateTheUser")
                    // allow everyone to see login page
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN").password("{noop}password");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                    .anyRequest().authenticated();
    }

}

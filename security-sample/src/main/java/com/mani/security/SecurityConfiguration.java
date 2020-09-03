package com.mani.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
spring security has its own authentication manager in which it will validate user
we cant directly user authentication manager instead we can provide our convenient functionality by adding the
authentication manager builder
Spring security internally uses delegation filter(bunch of filters) to provide authentication and authorization


application can have multiple authentication provider.. all those will be managed by authentication manager.
authentication provider do have support method through which manager will send the credentials to the provider
then spring internally has the user detail object.. it will store in the particular thread context

for the subsequent request, spring security has its own filter store the user context by using its own mechanism.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("testuser").password("testuser")
                .roles("USER").and().withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user").hasRole("USER")
                .antMatchers("/**").hasRole("ADMIN").and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}

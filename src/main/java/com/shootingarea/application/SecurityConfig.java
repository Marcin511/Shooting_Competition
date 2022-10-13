package com.shootingarea.application;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService (){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user1")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin1")
                .roles("ADMIN")
                .build();
       return new InMemoryUserDetailsManager(user,admin) ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/register")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/login")
                .permitAll()
                .antMatchers(HttpMethod.GET,"/users")
                .permitAll()
                .antMatchers(HttpMethod.GET,"/view/{id}")
                .permitAll()
                .antMatchers(HttpMethod.PUT,"/user/{id}")
                .permitAll()
                .antMatchers(HttpMethod.DELETE,"/user/{name}")
                .permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf()
                .disable();
    }
}

package com.facenet.tutorial.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.facenet.tutorial.security.ApplicationUserRole.*;

/**
 * This class was created at 11/28/2022 15:22:14
 *
 * @author Minh.LN
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index","/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       UserDetails jameUser =  User.builder()
                .username("Jame Bonds")
                .password(passwordEncoder.encode("1"))
                .roles(STUDENT.name())  // ROLE_STUDENT
                .build();

       UserDetails lindaAdmin = User.builder()
               .username("admin")
               .password(passwordEncoder.encode("1"))
               .roles(ADMIN.name())
               .build();

        UserDetails readAdmin = User.builder()
                .username("viceadmin")
                .password(passwordEncoder.encode("1"))
                .roles(ADMIN_TRAINEE.name())
                .build();
       return new InMemoryUserDetailsManager(jameUser, lindaAdmin, readAdmin);
    }
}

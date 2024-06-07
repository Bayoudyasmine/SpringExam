package com.example.springexam.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/admin/**").hasRole("MANAGER")
                        .requestMatchers("/techlead/**").hasRole("TECH_LEAD")
                        .requestMatchers("/api/**").hasAnyRole("DEV", "TEST", "DEVOPS")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .logout(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails manager = User.withDefaultPasswordEncoder()
                .username("manager")
                .password("password")
                .roles("MANAGER")
                .build();

        UserDetails techLead = User.withDefaultPasswordEncoder()
                .username("techlead")
                .password("password")
                .roles("TECH_LEAD")
                .build();

        UserDetails developer = User.withDefaultPasswordEncoder()
                .username("developer")
                .password("password")
                .roles("DEV")
                .build();

        return new InMemoryUserDetailsManager(manager, techLead, developer);
    }
}

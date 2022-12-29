/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.contractmanager.configuration;

import br.gov.sp.franciscomorato.contractmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;





/**
 * @see https://spring.io/guides/gs/securing-web/
 * @author vinicius
 */
@Configuration // deixando explicito que é uma classe de configuração
@EnableWebSecurity

public class WebConfiguration
{
    @Autowired protected UserService userService;
    

    /**
     * 
     * @param http
     * @return
     * @throws Exception 
     */
   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http    
                
                .authorizeHttpRequests((requests) -> 
                        requests.requestMatchers("/assets/**").permitAll()
                        .anyRequest().authenticated()
                    /*requests
                    .anyRequest().authenticated()*/
                )
                .formLogin((form) -> form
                   .loginPage("/").permitAll()
                        .defaultSuccessUrl("/home", true)
                )
                .logout((logout) -> logout.logoutUrl("/logout").permitAll()
                        .logoutSuccessUrl("/").permitAll()
                ).csrf().disable();
        return http.build();
    }
    
    @Autowired
    public void configure(AuthenticationManagerBuilder builder) throws Exception
    {
        builder.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}

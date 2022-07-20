package com.example.website;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("new")
                .password("pas")
                .roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable();
            httpSecurity.authorizeRequests()
                    .antMatchers("/admin").authenticated()
                    .antMatchers("/about", "/main", "/rare", "/form").permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/enter")
                    .loginProcessingUrl("/j_spring_security_check")
                    .defaultSuccessUrl("/admin")
                    .failureUrl("/main");
    }

    @Bean
    public PasswordEncoder encoder(){
        //Пароль не хешируется
        return NoOpPasswordEncoder.getInstance();
    }
}

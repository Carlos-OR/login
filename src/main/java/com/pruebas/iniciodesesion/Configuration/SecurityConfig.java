package com.pruebas.iniciodesesion.Configuration;

import com.pruebas.iniciodesesion.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/component/**", "/auth/**", "/public/**", "/css/**", "/js/**").permitAll().anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/auth/login").defaultSuccessUrl("/private/inicio", true)
                    .failureUrl("/auth/login?error=true").loginProcessingUrl("/auth/login-post").permitAll()
                .and()
                    .logout().logoutUrl("/logout").logoutSuccessUrl("/public/index");
    }
}

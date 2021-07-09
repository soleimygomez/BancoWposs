package com.prueba.wposs;

import com.prueba.wposs.services.impl.JpaUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JpaUserDetailService jpaUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()

                .antMatchers("/usuario/listar/**").hasAnyRole("ADMIN")
                .antMatchers("/salas/registrar/**").hasAnyRole("ADMIN")
                .antMatchers("/salas/retiro/**").hasAnyRole("ADMIN")
                .antMatchers("/salas/deposito/**").hasAnyRole("ADMIN")
                .antMatchers("/salas/tranferencia/**").hasAnyRole("ADMIN")
                .and()
                .formLogin().loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {

        builder
                .userDetailsService(jpaUserDetailService)
                .passwordEncoder(passwordEncoder());

     /*    PasswordEncoder encoder = passwordEncoder();
        UserBuilder users = User.builder().passwordEncoder(encoder::encode);

       builder.inMemoryAuthentication()
                .withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
                .withUser(users.username("brandon").password("12345").roles("USER")); */


    }


}

package com.mvc.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * <p><b> Nombre </b> Configuración de Spring Security</p>
 * <p><strong>Descripcion </strong> Configuración del proyecto MVC para añadir cuentas de admin para login</p>
 * @author	Toni Blanche y Dario Denche
 * @version	v1
 * @since	18/05/2021
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .and().formLogin()
            .loginPage("/login")
			.permitAll()
			.and()
			.logout()
			.permitAll();

    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Dario").password("dario").roles("ADMIN")
                .and().withUser("Yelder").password("yelder").roles("ADMIN")
                .and().withUser("Antonia").password("antonia").roles("ADMIN")
                .and().withUser("Toni").password("toni").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
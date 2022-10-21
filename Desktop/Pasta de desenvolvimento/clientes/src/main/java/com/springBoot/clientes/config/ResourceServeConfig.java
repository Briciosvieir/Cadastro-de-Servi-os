package com.springBoot.clientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableResourceServer
public class ResourceServeConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) {
		try {
			http.authorizeRequests()
					.antMatchers("/api/usuarios").permitAll()
					.antMatchers("/h2-console/**").permitAll()
					.antMatchers("/api/clientes**","/api/servicos-prestados/**").authenticated()
					.anyRequest().denyAll()
					.and().headers().frameOptions().sameOrigin();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

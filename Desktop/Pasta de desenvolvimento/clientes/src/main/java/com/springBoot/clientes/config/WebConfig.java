package com.springBoot.clientes.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig  {
	@Bean
	public FilterRegistrationBean<CorsFilter> cosFilter(){
		List<String> all = Arrays.asList("*");

		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOriginPatterns(all);
		corsConfiguration.setAllowedHeaders(all);
		corsConfiguration.setAllowedMethods(all);
		corsConfiguration.setAllowCredentials(true);




		UrlBasedCorsConfigurationSource souce = new UrlBasedCorsConfigurationSource();
		souce.registerCorsConfiguration("/**",corsConfiguration);

		CorsFilter corsFilter = new CorsFilter(souce);
		FilterRegistrationBean filter = new FilterRegistrationBean<>(corsFilter);
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filter;

	}
}

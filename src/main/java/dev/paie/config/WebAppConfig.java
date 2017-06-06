package dev.paie.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dev.paie.service.CotisationService;
import dev.paie.service.InitialiserDonneesServiceDev;
import dev.paie.spring.DataSourceMySQLConfig;

@Configuration
@EnableWebMvc
@Import({ServicesConfig.class,JpaConfig.class, DataSourceMySQLConfig.class})
@ComponentScan("dev.paie.web.controller")
public class WebAppConfig {

	@Autowired private InitialiserDonneesServiceDev initService;
	
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}

	
	@PostConstruct
	public void init(){
		initService.initialiser();
	}
}
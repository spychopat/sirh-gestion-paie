package dev.paie.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dev.paie.service.InitialiserDonneesService;
import dev.paie.spring.DataSourceMySQLConfig;


@Configuration
@EnableWebMvc
@ComponentScan("dev.paie.web.controller")
@ImportResource({"classpath:grades.xml","classpath:entreprises.xml","classpath:profils-remuneration.xml","classpath:cotisations-imposables.xml","classpath:cotisations-non-imposables.xml"})
@Import({ServicesConfig.class})
public class WebAppConfig {
	
    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }
    
    @Autowired
    InitialiserDonneesService init;
    
    @PostConstruct
    public void onPostConstruc() {
        init.initialiser();
    }
    
}
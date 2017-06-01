package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import dev.paie.spring.DataSourceMySQLConfig;

@Configuration
@ComponentScan("dev.paie.service")
@Import(DataSourceMySQLConfig.class)
public class ServicesConfig {

}
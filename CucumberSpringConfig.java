package com.usbank.cashflow.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan("com.usbank.cashflow")
@PropertySources({@PropertySource("classpath:application.properties")})
public class CucumberSpringConfig {
}

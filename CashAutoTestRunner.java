package com.usbank.cashflow;


import com.usbank.cashflow.config.CucumberSpringConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "classpath:features/calculator.feature" },
        glue = {"com.usbank.cashflow" })
@CucumberContextConfiguration
@SpringBootTest(classes = CucumberSpringConfig.class)
public class CashAutoTestRunner {
}

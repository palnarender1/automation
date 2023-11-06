package com.usbank.cashflow;


import com.usbank.cashflow.config.JDBCTemplateConfig;
import com.usbank.cashflow.model.Transaction;
import com.usbank.cashflow.service.Calculator;
import com.usbank.cashflow.service.UserDAO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class CalculatorRunSteps {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private int total;

    private Calculator calculator;

    @Before
    private void init() {
        total = -999;
    }

    @Given("^I have a calculator$")
    public void initializeCalculator() throws Throwable {
        calculator = new Calculator();
    }

    @When("^I add (-?\\d+) and (-?\\d+)$")
    public void testAdd(int num1, int num2) throws Throwable {
        total = calculator.add(num1, num2);

        List<Transaction> txnList = jdbcTemplate.query("SELECT * FROM budgetdb.transaction",

                new RowMapper<Transaction>() {
            @Override
            public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Transaction.builder().amount(rs.getInt("id"))
                        .description(rs.getString("description"))
                        .userId(rs.getString("user_id"))
                        .build();
            }
        });

        log.info("Total Number of TXN: {}",txnList.size());
        

    }

    @Then("^the result should be (-?\\d+)$")
    public void validateResult(int result) throws Throwable {

    }
}
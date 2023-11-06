package com.usbank.cashflow.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDAO {
    @Value("${database.url}")
    private String url;

    public void show(){
        log.info("NARENDER PAL SINGH"+url);
    }
}

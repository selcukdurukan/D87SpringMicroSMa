package com.ba.boost;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class ElasticServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(ElasticServiceApplication.class, args);
    }
}
package com.ba.boost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //elastic-service'e data gönderebilmesi için açıyoruz.(manager-feign client'ın açılması)
public class UserProfileMicroServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(UserProfileMicroServiceApplication.class, args);
    }
}
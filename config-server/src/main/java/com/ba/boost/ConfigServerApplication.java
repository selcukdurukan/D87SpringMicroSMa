package com.ba.boost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //Bunu eklemeyi unutursan config server olarak çalışmaz.
public class ConfigServerApplication {
    public static void main(String[] args) {

        SpringApplication.run(ConfigServerApplication.class, args);

    }
}
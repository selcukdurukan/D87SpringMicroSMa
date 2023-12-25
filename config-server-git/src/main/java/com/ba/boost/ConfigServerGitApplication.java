package com.ba.boost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerGitApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerGitApplication.class, args);
    }

    /**
     *
     * http://localhost:8888/auth-service-application.yml
     *
     * Bilgileri github'tan repodan çeker.
     * */
}
package com.maia.vinicius.desafiobackenditau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DesafioBackendItauApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioBackendItauApplication.class, args);
    }

}

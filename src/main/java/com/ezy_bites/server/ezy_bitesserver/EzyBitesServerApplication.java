package com.ezy_bites.server.ezy_bitesserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EzyBitesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzyBitesServerApplication.class, args);
        System.out.println("Working");
    }

}

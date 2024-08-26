package com.example.uesr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.uesr.mapper")  // 确保包名正确
public class CurryApplication {

    public static void main(String[] args) {
        System.out.println("Starting CurryApplication...");

        try {
            SpringApplication.run(CurryApplication.class, args);
        } catch (Exception e) {
            System.err.println("Application failed to start:");
            e.printStackTrace();
        }

        System.out.println("CurryApplication started.");
    }
}

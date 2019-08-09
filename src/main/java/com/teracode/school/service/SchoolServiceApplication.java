package com.teracode.school.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.teracode")
public class SchoolServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SchoolServiceApplication.class, args);
  }

}
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.controller"})
//@ComponentScan(basePackages = {"com.example.entity"})
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}


//      Why we use???

//      @ComponentScan(basePackages = {"com.example.controller"})----->
//             1. when we keep main application in a package it searching for it so we have to mention it.(or)remove from the package...
//                  2. When you place the main Spring Boot application class in a package, Spring Boot uses component scanning to detect and register beans from the same package and its sub-packages by default.
//                      If your controllers or other components are in a different package outside this hierarchy, Spring won't automatically detect them.
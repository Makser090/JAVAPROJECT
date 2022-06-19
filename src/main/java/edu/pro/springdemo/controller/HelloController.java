package edu.pro.springdemo.controller;/*
  @author   makse
  @project   spring-demo
  @class  HelloController
  @version  1.0.0 
  @since 23.03.2022 - 15.50
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HelloController {

    @GetMapping("/hello")
    String sayHello(){
        String out = "<h2> Hello, Spring Controller </h2>";
        int year = LocalDate.now().getYear();
        out += year;
        return out;
    }
}

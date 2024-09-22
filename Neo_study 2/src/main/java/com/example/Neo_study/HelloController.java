package com.example.Neo_study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloController {
    @Value("${nekruz}")
    private String nekruz;
    @GetMapping("/hello")
    public String hello() {
        System.out.println(this.nekruz);
        return "hello";
    }
}

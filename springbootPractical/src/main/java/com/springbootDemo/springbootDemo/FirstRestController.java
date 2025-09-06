package com.springbootDemo.springbootDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class FirstRestController {

    @GetMapping("/first")
    public String getUI(){
        return "Hello From Springboot";
    }

}

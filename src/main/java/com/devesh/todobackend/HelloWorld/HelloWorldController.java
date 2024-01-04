package com.devesh.todobackend.HelloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class HelloWorldController {

    @GetMapping("/bean")
    public HelloWorldBean getHelloBean(){
        return new HelloWorldBean("Hello World");
    }
}

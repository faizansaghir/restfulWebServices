package io.github.faizansaghir.restful_web_services.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String getHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean getHelloWorldBean(){
        return new HelloWorldBean("Hello World");
    }
}

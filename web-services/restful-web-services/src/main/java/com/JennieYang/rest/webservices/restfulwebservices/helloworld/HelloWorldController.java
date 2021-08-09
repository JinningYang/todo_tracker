package com.JennieYang.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//Controller
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class HelloWorldController {
    //method return "Hello World"
    //GET
    //URL - /hello-world
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    //hello-world-bean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    //hello-world/path-variable/JY
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        //throw new RuntimeException("Something went wrong");
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}

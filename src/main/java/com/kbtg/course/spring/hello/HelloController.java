package com.kbtg.course.spring.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public HelloResponse sayHi(@PathVariable String name) {
        return generateSuccess(name);
    }

    private HelloResponse generateSuccess(@PathVariable String name) {
        HelloResponse response = new HelloResponse();
        response.setHeader(new Header(200,"Success"));
        response.setBody(new Body("Hello " + name));
        return response;
    }

}

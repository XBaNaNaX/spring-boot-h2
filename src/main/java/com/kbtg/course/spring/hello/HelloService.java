package com.kbtg.course.spring.hello;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class HelloService {

    public HelloResponse generateSuccess(@PathVariable String name) {
        HelloResponse response = new HelloResponse();
        response.setHeader(new Header(200,"Success"));
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        response.setBody(new Body("Hello " + name));
        return response;
    }
}

package com.kbtg.course.spring.hello;

public class HelloResponse {
    Header HeaderObject;
    Body BodyObject;


    // Getter Methods

    public Header getHeader() {
        return HeaderObject;
    }

    public Body getBody() {
        return BodyObject;
    }

    // Setter Methods

    public void setHeader(Header headerObject) {
        this.HeaderObject = headerObject;
    }

    public void setBody(Body bodyObject) {
        this.BodyObject = bodyObject;
    }
}

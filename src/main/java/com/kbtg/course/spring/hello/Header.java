package com.kbtg.course.spring.hello;

public class Header {
    private int code;
    private String message;

    public Header() {

    }

    public Header(int code, String message) {
        this.code = code;
        this.message = message;
    }


    // Getter Methods

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    // Setter Methods

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

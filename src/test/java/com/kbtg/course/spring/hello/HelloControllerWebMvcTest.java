package com.kbtg.course.spring.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMockMvcSayHi() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/hello/meow")).andReturn();
        String response = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();

        HelloResponse actualResponse = objectMapper.readValue(response, HelloResponse.class);

        assertEquals("Hello Meow", actualResponse.getBody().getResult());
    }
}

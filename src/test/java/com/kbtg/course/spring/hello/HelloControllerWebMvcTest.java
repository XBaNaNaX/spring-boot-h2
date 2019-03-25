package com.kbtg.course.spring.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Test
    public void testMockMvcSayHi() throws Exception {

        //Test Double :: Stub
        HelloResponse expectedResponse = new HelloResponse();
        expectedResponse.setHeader(new Header(200,"Success"));
        expectedResponse.setBody(new Body("Hello Meow"));

        given(helloService.generateSuccess("meow")).willReturn(expectedResponse);

        MvcResult mvcResult = mockMvc.perform(get("/hello/meow")).andReturn();
        String response = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();

        HelloResponse actualResponse = objectMapper.readValue(response, HelloResponse.class);

        assertEquals("Hello Meow", actualResponse.getBody().getResult());
    }
}

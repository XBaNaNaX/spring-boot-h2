package com.kbtg.course.spring.hello;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerUnitTest {

    @Mock
    private HelloService helloService;

    @Test
    public void testMockMvcSayHi() throws Exception {

        // Test double :: stub
        HelloResponse expectedResponse = new HelloResponse();
        expectedResponse.setHeader(new Header(200, "Success"));
        expectedResponse.setBody(new Body("Hello Xxx"));
        given(helloService.generateSuccess("xxx"))
                .willReturn(expectedResponse);

        HelloController controller
                = new HelloController(helloService);
        HelloResponse actualResponse = controller.sayHi("xxx");

        assertEquals("Hello Xxx",
                actualResponse.getBody().getResult());
    }

}

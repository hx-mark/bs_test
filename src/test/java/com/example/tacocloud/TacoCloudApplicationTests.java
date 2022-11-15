package com.example.tacocloud;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.example.tacocloud.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
@SpringBootTest
class TacoCloudApplicationTests {
    @Autowired
    private MockMvc mockMvc; // 注入mockMvc

    @Test
    void contextLoads() {
    }

    @Test
    public void testHomePage() throws Exception{
        mockMvc.perform(get("/")).
                andExpect(status().isOk()).
                andExpect(view().name("home")).
                andExpect(content().string(containsString("welcome to ...")));
    }

}

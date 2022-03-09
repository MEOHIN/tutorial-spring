package jpa.bookmanager.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@WebMvcTest     // = 슬라이스 테스트: 전체 Spring Context 를 로딩하지 않고 Web Controller 에 대한 일부 Bean 들을 로딩해서 테스트함 -> JPA 옵션에서 예외 발생
//@MockBean(JpaMetamodelMappingContext.class)   // 슬라이스 테스트로 인한 문제 해결방법1
@SpringBootTest
class HelloWorldControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

//    @WebMvcTest 에서 자동으로 만들어줬던 MockMvc 를 직접 만들기
    @BeforeEach
    void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void helloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello-world"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello-world"));
    }
}
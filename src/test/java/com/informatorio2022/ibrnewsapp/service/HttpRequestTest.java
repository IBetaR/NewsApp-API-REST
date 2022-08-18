package com.informatorio2022.ibrnewsapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Integration Test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    @Timeout(value = 400 , unit = TimeUnit.MILLISECONDS)
    @DisplayName("Integration Test: Should return welcome message, Test will fail if timeout exceeds 400 ms")
    public void greetingShouldReturnWelcomeMessage() throws Exception{
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/newsapp/",
                String.class)).contains("Bienvenido A NewsApp API REST");

    }

    @Test
    @DisplayName("Integration Test: Should return successful route message to ArticleController")
    public void greetingFromArticleControllerShouldReturnMessage() throws Exception{
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/newsapp/articles/greeting",
                String.class)).contains("Esta es la ruta de ArticleController");
    }

}

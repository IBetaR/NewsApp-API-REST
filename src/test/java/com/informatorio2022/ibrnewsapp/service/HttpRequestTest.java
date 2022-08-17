package com.informatorio2022.ibrnewsapp.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Should return welcome message")
    public void greetingShouldReturnWelcomeMessage() throws Exception{
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/newsapp/",
                String.class)).contains("Bienvenido A NewsApp API REST");
    }

    @Test
    @DisplayName("Should return successful route message to ArticleController")
    public void greetingFromArticleControllerShouldReturnMessage() throws Exception{
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/newsapp/articles/greeting",
                String.class)).contains("Esta es la ruta de ArticleController");
    }

}

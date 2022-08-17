package com.informatorio2022.ibrnewsapp;

import com.informatorio2022.ibrnewsapp.controller.ArticleController;
import com.informatorio2022.ibrnewsapp.controller.AuthorController;
import com.informatorio2022.ibrnewsapp.controller.SourceController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class IbrnewsAppSmokeTest {

    @Autowired
    private ArticleController articleController;

    @Autowired
    private AuthorController authorController;

    @Autowired
    private SourceController sourceController;

    @Test
    @DisplayName("NewsApp ArticleController Smoke test")
    void SmokeTestArticleContextLoads() throws Exception{
        assertThat(articleController).isNotNull();
    }

    @Test
    @DisplayName("NewsApp AuthorController Smoke test")
    void SmokeTestAuthorContextLoads() throws Exception{
        assertThat(authorController).isNotNull();
    }

    @Test
    @DisplayName("NewsApp SourceController Smoke test")
    void SmokeTestSourceContextLoads() throws Exception{
        assertThat(sourceController).isNotNull();
    }

    @Test
    @DisplayName("NewsApp ArticleController has Not Null Fields Or Properties")
    void SmokeTestArticleSourceContext() throws Exception{
        assertThat(articleController).hasNoNullFieldsOrProperties();
    }


    @Test
    @DisplayName("NewsApp AuthorController has Not Null Fields Or Properties")
    void SmokeTestAuthorSourceContext() throws Exception{
        assertThat(authorController).hasNoNullFieldsOrProperties();
    }

    @Test
    @DisplayName("NewsApp SourceController has Not Null Fields Or Properties")
    void SmokeTestSourceContext() throws Exception{
        assertThat(sourceController).hasNoNullFieldsOrProperties();
    }

}

package com.informatorio2022.ibrnewsapp.controller;

import com.informatorio2022.ibrnewsapp.persistence.entity.Article;
import com.informatorio2022.ibrnewsapp.persistence.repository.ArticleRepository;
import com.informatorio2022.ibrnewsapp.service.ArticleServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ArticleControllerTest extends BaseControllerImpl <Article, ArticleServiceImpl> {

    ArticleRepository articleRepositoryMock = Mockito.mock(ArticleRepository.class);

//    @Autowired
//    ArticleController articleController = new ArticleController(articleRepositoryMock);

    @BeforeEach
    void setUp() {
        System.out.printf("Before Testing");
    }

    @Test
    void search() {
        System.out.printf("While Testing");
    }


    @Test
    void testSearch() {
        System.out.printf("While Testing");
    }

    @Test
    void findAllByArticleStatus() {
        System.out.printf("While Testing");
    }

    @AfterEach
    void tearDown() {
        System.out.printf("After Testing");
    }
}
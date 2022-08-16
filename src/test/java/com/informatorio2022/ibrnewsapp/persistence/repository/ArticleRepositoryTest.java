package com.informatorio2022.ibrnewsapp.persistence.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void saveArticleTest(){

    }

    @Test
    void findByTitleContainingOrDescriptionContaining() {

    }

    @Test
    void testFindByTitleContainingOrDescriptionContaining() {
    }

    @Test
    void findAllByArticleStatus() {
    }
}
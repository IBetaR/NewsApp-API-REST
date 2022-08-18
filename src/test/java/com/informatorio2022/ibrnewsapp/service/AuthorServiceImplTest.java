package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.dto.NewsPortalCompanyDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;


class AuthorServiceImplTest {

    @Autowired
    private AuthorServiceImpl authorService;

    @Test
    void search() {
    }

    @Test
    void testSearch() {
    }

//    @Test
//    @DisplayName("Negative Test case - Create a Author with Null data")
//    void createAuthorWithNull() {
//        AuthorServiceImpl authorService1 = new AuthorServiceImpl(authorService.baseRepository);
//
//        assertThatExceptionOfType(NullPointerException.class);
//    }
}
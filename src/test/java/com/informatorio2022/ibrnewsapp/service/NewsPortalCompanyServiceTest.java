package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.dto.NewsPortalCompanyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NewsPortalCompanyServiceTest {

    private NewsPortalCompanyService service = new NewsPortalCompanyService();

    @BeforeEach
    public void setUp(){
        service = new NewsPortalCompanyService();
    }


    @Test
    @DisplayName("Test case - Create a News company. New company crated")
    void createCompany() {
        NewsPortalCompanyDTO companyDTO = new NewsPortalCompanyDTO(1L,"BBC","1234");
        final NewsPortalCompanyDTO result = service.createCompany(1L, "BBC","1234");

        assertAll(
                () -> assertEquals(companyDTO.getId(), result.getId()),
                () -> assertEquals(companyDTO.getName(),result.getName()),
                () -> assertEquals(companyDTO.getCuit(),result.getCuit())
        );
    }

    @Test
    @DisplayName("Negative Test case - Create a News company")
    void negativeTestCreateCompany() {
        NewsPortalCompanyDTO companyDTO = new NewsPortalCompanyDTO(1L,"BBC","1234");
        final NewsPortalCompanyDTO result = service.createCompany(2L, "ASB","4322");

        assertAll(
                () -> assertNotEquals(companyDTO.getId(), result.getId()),
                () -> assertNotEquals(companyDTO.getName(),result.getName()),
                () -> assertNotEquals(companyDTO.getCuit(),result.getCuit())
        );
    }

    @Test
    @DisplayName("Get a company created by its ID")
    void getCompanyByAnExistingId() {
        NewsPortalCompanyDTO companyDTO2 = new NewsPortalCompanyDTO(2L,"ASB","4322");
        final NewsPortalCompanyDTO result = service.createCompany(2L, "ASB","4322");

        assertEquals(companyDTO2.getId(),result.getId());

    }

    @Test
    @DisplayName("Negative Test - Get a company created by its ID")
    void getCompanyByInExistingId() {

        final NewsPortalCompanyDTO result = service.getCompany(10L);

        assertEquals(null,result);
    }

    @Test
    void updateCompany() {
        NewsPortalCompanyDTO companyDTO2 = new NewsPortalCompanyDTO(2L,"ASB","4322");
        final NewsPortalCompanyDTO result = service.updateCompany(2L,"ASB","4322");

        assertAll(
                () -> assertEquals(companyDTO2.getId(), result.getId()),
                () -> assertEquals(companyDTO2.getName(),result.getName()),
                () -> assertEquals(companyDTO2.getCuit(),result.getCuit())
        );
    }
}
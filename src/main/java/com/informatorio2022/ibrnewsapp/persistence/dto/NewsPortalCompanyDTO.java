package com.informatorio2022.ibrnewsapp.persistence.dto;

public class NewsPortalCompanyDTO {

    private Long id;
    private String name;
    private String cuit;

    public NewsPortalCompanyDTO(Long id, String name, String cuit) {
        this.id = id;
        this.name = name;
        this.cuit = cuit;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCuit() {
        return cuit;
    }
}

package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.dto.NewsPortalCompanyDTO;

import java.util.HashMap;

public class NewsPortalCompanyService {

    private HashMap<Long, NewsPortalCompanyDTO> companyDTOHashMap = new HashMap<>();

    public NewsPortalCompanyDTO createCompany(Long id, String name, String cuit) {
        companyDTOHashMap.put(id, new NewsPortalCompanyDTO(id, name, cuit));
        return companyDTOHashMap.get(id);
    }

    public NewsPortalCompanyDTO getCompany(Long id){
        return companyDTOHashMap.get(id);
    }

    public NewsPortalCompanyDTO updateCompany(Long id, String name, String cuit){
        companyDTOHashMap.put(id, new NewsPortalCompanyDTO(id,name,cuit));
        return companyDTOHashMap.get(id);
    }
}

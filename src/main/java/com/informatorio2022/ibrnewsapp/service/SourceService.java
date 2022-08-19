package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.entity.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface SourceService extends BaseService<Source, Long>{

    List<Source> search(String search) throws Exception;
    Page<Source> search(String search, Pageable pageable) throws Exception;
}

package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService extends BaseService<Author, Long>{

    List<Author> search(String filter) throws Exception;
    Page<Author> search(String filter, Pageable pageable) throws Exception;
}

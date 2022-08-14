package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService extends BaseService <Article, Long>{

//    List<Article> search(String filter) throws Exception;
//    Page<Article> search(String filter, Pageable pageable) throws Exception;
}

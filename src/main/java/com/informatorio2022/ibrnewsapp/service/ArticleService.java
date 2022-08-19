package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.entity.Article;
import com.informatorio2022.ibrnewsapp.persistence.entity.ArticleStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService extends BaseService <Article, Long>{

//    List<Article> getAllPublished();
    List<Article> search(String search) throws Exception;
    List<Article> findAllByArticleStatus(ArticleStatus articleStatus) throws Exception;
    Page<Article> search(String search, Pageable pageable) throws Exception;

}

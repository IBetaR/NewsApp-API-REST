package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.entity.Article;
import com.informatorio2022.ibrnewsapp.persistence.repository.ArticleRepository;
import com.informatorio2022.ibrnewsapp.persistence.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article, Long> implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(BaseRepository<Article, Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public List<Article> search(String filter) throws Exception{
        try {
            List<Article> articles = articleRepository.findByTitleContainingOrDescriptionContaining(filter,filter);
            //List<Article> articles = articleRepository.search(filter);
            //List<Article> articles = articleRepository.searchNative(filter);
            return articles;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Article> search(String filter, Pageable pageable) throws Exception {
        try {
            Page<Article> articles = articleRepository.findByTitleContainingOrDescriptionContaining(filter,filter, pageable);
            //Page<Article> articles = articleRepository.search(filter, pageable);
            //Page<Article> articles = articleRepository.searchNative(filter, pageable);
            return articles;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

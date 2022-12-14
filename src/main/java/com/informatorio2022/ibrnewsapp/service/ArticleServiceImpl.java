package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.exceptions.NewsAppExceptions;
import com.informatorio2022.ibrnewsapp.persistence.entity.Article;
import com.informatorio2022.ibrnewsapp.persistence.entity.ArticleStatus;
import com.informatorio2022.ibrnewsapp.persistence.repository.ArticleRepository;
import com.informatorio2022.ibrnewsapp.persistence.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article, Long> implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(BaseRepository<Article, Long> baseRepository){
        super(baseRepository);
    }

//    @Override
//    public List<Article> getAllPublished() {
//        List<Article> articles = articleRepository.getAllPublished();
//                return articles;
//    };

    @Override
    public List<Article> search(String search) throws Exception{
        if(search.length()>=3 && !search.isBlank()){
            try {
                List<Article> articles = articleRepository.findByTitleContainingOrDescriptionContaining(search,search);
                //List<Article> articles = articleRepository.search(search);
                //List<Article> articles = articleRepository.searchNative(search);
                return articles;
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        throw new  NewsAppExceptions("Verifique criterio de búsqueda, debe ser mayor o igual a 3 caracteres ", HttpStatus.NO_CONTENT);
    }

    @Override
    public Page<Article> search(String search, Pageable pageable) throws Exception {
        if(search.length()>=3 && !search.isBlank()){
            try {
                Page<Article> articles = articleRepository.findByTitleContainingOrDescriptionContaining(search,search, pageable);
                //Page<Article> articles = articleRepository.search(filter, pageable);
                //Page<Article> articles = articleRepository.searchNative(filter, pageable);
                return articles;
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        throw new  NewsAppExceptions("Verifique criterio de búsqueda, debe ser mayor o igual a 3 caracteres ", HttpStatus.NO_CONTENT);
    }

    public List<Article> findAllByArticleStatus(ArticleStatus articleStatus){
        return this.articleRepository.findAllByArticleStatus(articleStatus);
    }

}

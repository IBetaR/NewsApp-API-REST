package com.informatorio2022.ibrnewsapp.persistence.repository;

import com.informatorio2022.ibrnewsapp.persistence.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends BaseRepository <Article, Long> {

    List<Article> findByTitleContainingOrDescriptionContaining(String title, String description);
    Page<Article> findByTitleContainingOrDescriptionContaining(String name, String description, Pageable pageable);

//
//    @Query("SELECT a FROM Article a WHERE a.title LIKE %:filter% or a.content LIKE %:filter%")
//    List<Article> search(@Param("filter") String filter); *****
//
//    @Query("SELECT a FROM Article a WHERE a.name LIKE %:filter% or a.word LIKE %:filter%")
//    Page<Article> search(@Param("filter") String filter, Pageable pageable);
//
//    @Query(
//            value = "SELECT * FROM article WHERE article.name LIKE %:filter% or article.word LIKE %:filter%",
//            nativeQuery = true
//    )
//    List<Article> searchNative(@Param("filter") String filter);
//
//    @Query(
//            value = "SELECT * FROM article WHERE article.name LIKE %:filter% or article.word LIKE %:filter%",
//            countQuery = "SELECT count(*) FROM article",
//            nativeQuery = true
//    )
//    Page<Article> searchNative(@Param("filter") String filter, Pageable pageable);
}

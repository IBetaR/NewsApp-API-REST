package com.informatorio2022.ibrnewsapp.controller;

import com.informatorio2022.ibrnewsapp.exceptions.NewsAppExceptions;
import com.informatorio2022.ibrnewsapp.persistence.entity.Article;
import com.informatorio2022.ibrnewsapp.persistence.entity.ArticleStatus;
import com.informatorio2022.ibrnewsapp.service.ArticleServiceImpl;
import com.sun.istack.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/newsapp/articles")
public class ArticleController extends BaseControllerImpl <Article, ArticleServiceImpl> {

    @GetMapping("search")
    @NotBlank(message = "No puede haber búsqueda vacía")
    public ResponseEntity<?> search(@RequestParam String filter){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\""+e.getMessage()+ ", Error en búsqueda.\"}");
        }
    }

    @GetMapping("searchPaged")
    @NotBlank
    public ResponseEntity<?> search(@RequestParam String filter, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\""+e.getMessage()+ ", Error en búsqueda.\"}");
        }
    }

    @GetMapping("/status/{status}")
    public List<Article> findAllByArticleStatus(@PathVariable("status") ArticleStatus articleStatus){
        try {
            return this.service.findAllByArticleStatus(articleStatus);
        }catch (Exception e){
            throw new NewsAppExceptions("Verifique request, Status debe estar en Mayúscula y sin espacios ",HttpStatus.BAD_REQUEST);
        }
    }
}

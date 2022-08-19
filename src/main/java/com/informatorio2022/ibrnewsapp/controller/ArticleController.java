package com.informatorio2022.ibrnewsapp.controller;

import com.informatorio2022.ibrnewsapp.exceptions.NewsAppExceptions;
import com.informatorio2022.ibrnewsapp.persistence.entity.Article;
import com.informatorio2022.ibrnewsapp.persistence.entity.ArticleStatus;
import com.informatorio2022.ibrnewsapp.service.ArticleServiceImpl;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.function.Predicate;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/newsapp/articles", produces =  MediaType.APPLICATION_JSON_VALUE)
public class ArticleController extends BaseControllerImpl <Article, ArticleServiceImpl> {

//    @GetMapping("/")
//    @NotBlank(message = "No puede haber búsqueda vacía")
//    public ResponseEntity<?> getAllPublished(){
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(service.findAll().stream().allMatch((Predicate<? super Article>) findAllByArticleStatus(ArticleStatus.valueOf("PUBLISHED"))));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\""+e.getMessage()+ ", Error en búsqueda.\"}");
//        }
//    }

    @GetMapping("/")
    @NotBlank(message = "No puede haber búsqueda vacía")
    public ResponseEntity<?> search(@RequestParam String search){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(search));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\""+e.getMessage()+ ", Error en búsqueda.\"}");
        }
    }

    @GetMapping("/searchPaged")
    @NotBlank
    public ResponseEntity<?> search(@RequestParam String search, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(search, pageable));
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

    @RequestMapping("/greeting")
    public @ResponseBody String SearchGreeting(){
        return "Esta es la ruta de ArticleController";
    }



}

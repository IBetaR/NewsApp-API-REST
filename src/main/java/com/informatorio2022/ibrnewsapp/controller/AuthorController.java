package com.informatorio2022.ibrnewsapp.controller;

import com.informatorio2022.ibrnewsapp.exceptions.NewsAppExceptions;
import com.informatorio2022.ibrnewsapp.persistence.entity.Author;
import com.informatorio2022.ibrnewsapp.service.AuthorServiceImpl;
import com.sun.istack.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/newsapp/authors")
public class AuthorController extends BaseControllerImpl<Author, AuthorServiceImpl> {

    @GetMapping("search")
    @NotBlank
    public ResponseEntity<?> search(@RequestParam String filter){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error, NOT FOUND\":\""+e.getMessage()+ ", Búsqueda no encontrada.\"}");
        }
    }

    @GetMapping("searchPaged")
    @NotBlank
    public ResponseEntity<?> search(@RequestParam  String filter, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error, NOT FOUND\":\""+e.getMessage()+ ", Páginas y búsqueda no encontrada.\"}");
        }
    }

//    @GetMapping("search/date/after")
//    @NotNull
//    public List<Author> findByCreateDateAfter(ZonedDateTime createdDate){
//        try {
//            return this.service.findByCreateDateAfter(createdDate);
//        }catch (Exception e){
//            throw new NewsAppExceptions("Verifique request, Status debe estar en Mayúscula y sin espacios ",HttpStatus.BAD_REQUEST);
//        }
//    }


}

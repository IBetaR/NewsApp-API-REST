package com.informatorio2022.ibrnewsapp.controller;

import com.informatorio2022.ibrnewsapp.persistence.entity.Author;
import com.informatorio2022.ibrnewsapp.service.AuthorServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/newsapp/authors")
public class AuthorController extends BaseControllerImpl<Author, AuthorServiceImpl> {

    @GetMapping("search")
    public ResponseEntity<?> search(@RequestParam String filter){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error, NOT FOUND\":\""+e.getMessage()+ ", Búsqueda no encontrada.\"}");
        }
    }

    @GetMapping("searchPaged")
    public ResponseEntity<?> search(@RequestParam String filter, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error, NOT FOUND\":\""+e.getMessage()+ ", Páginas y búsqueda no encontrada.\"}");
        }
    }


}

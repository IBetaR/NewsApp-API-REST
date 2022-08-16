package com.informatorio2022.ibrnewsapp.controller;

import com.informatorio2022.ibrnewsapp.persistence.entity.Source;
import com.informatorio2022.ibrnewsapp.service.SourceServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/newsapp/sources")
public class SourceController extends BaseControllerImpl<Source, SourceServiceImpl>{

    @GetMapping("search")
    @NotBlank
    public ResponseEntity<?> search(@RequestParam String filter){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error, NOT FOUND\":\""+e.getMessage()+ ", Fuente no encontrada.\"}");
        }
    }

    @GetMapping("searchPaged")
    @NotBlank
    public ResponseEntity<?> search(@RequestParam String filter, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error, NOT FOUND\":\""+e.getMessage()+ ", Fuentes y búsqueda no encontrada.\"}");
        }
    }
}

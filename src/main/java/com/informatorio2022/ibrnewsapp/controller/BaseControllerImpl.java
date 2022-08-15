package com.informatorio2022.ibrnewsapp.controller;

import com.informatorio2022.ibrnewsapp.exceptions.NewsAppExceptions;
import com.informatorio2022.ibrnewsapp.persistence.entity.Base;
import com.informatorio2022.ibrnewsapp.service.BaseServiceImpl;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl<E extends Base, S extends
        BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

    @Autowired
    protected S service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) throws NewsAppExceptions {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"NOT_FOUND\":\"Recurso no encontrado en la base de datos, revise la request.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody @NotNull E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"BAD REQUEST\":\"Error Por favor revise la request.\"}");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable @NotNull Long id, @RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"BAD REQUEST\":\"Error Por favor revise la request.\"}");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"BAD REQUEST\":\"Error Por favor revise la request.\"}");
        }
    }
}
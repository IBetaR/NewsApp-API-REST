package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.exceptions.NewsAppExceptions;
import com.informatorio2022.ibrnewsapp.persistence.entity.Base;
import com.informatorio2022.ibrnewsapp.persistence.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception{
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        Optional<E> optionalE =this.baseRepository.findById(id);
        if(!optionalE.isEmpty()){
            try {
                Optional<E> entityOptional = baseRepository.findById(id);
                return entityOptional.get();
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        throw new NewsAppExceptions("ID que usted busca no existe en la Base de Datos", HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            E entityUpdate = entityOptional.get();
            entityUpdate = baseRepository.save(entity);
            return entityUpdate;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if (baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("ID No existe");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}


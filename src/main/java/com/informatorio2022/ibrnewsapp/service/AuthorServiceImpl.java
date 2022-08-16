package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.exceptions.NewsAppExceptions;
import com.informatorio2022.ibrnewsapp.persistence.entity.Author;
import com.informatorio2022.ibrnewsapp.persistence.repository.AuthorRepository;
import com.informatorio2022.ibrnewsapp.persistence.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author, Long> implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(BaseRepository<Author, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Author> search(String filter) throws Exception {
        if(filter.length()>=3 && !filter.isBlank()){
            try {
                List<Author> authors = authorRepository.findByFirstnameContainingOrLastnameContaining(filter,filter);
                //List<Author> authors = authorRepository.search(filter);
                //List<Author> authors = authorRepository.searchNative(filter);
                return authors;
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        throw new NewsAppExceptions("Verifique criterio de búsqueda, debe ser mayor o igual a 3 caracteres ", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Page<Author> search(String filter, Pageable pageable) throws Exception {
        if(filter.length()>=3 && !filter.isBlank()){
            try {
                Page<Author> authors = authorRepository.findByFirstnameContainingOrLastnameContaining(filter,filter, pageable);
                //Page<Author> authors = authorRepository.search(filter, pageable);
                //Page<Author> authors = authorRepository.searchNative(filter, pageable);
                return authors;
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        throw new NewsAppExceptions("Verifique criterio de búsqueda, debe ser mayor o igual a 3 caracteres. ", HttpStatus.BAD_REQUEST);
    }

//    public List<Author> findByCreateDateAfter(ZonedDateTime createdDate){
//        return this.authorRepository.findByCreateDateAfter(createdDate);
//    }


}

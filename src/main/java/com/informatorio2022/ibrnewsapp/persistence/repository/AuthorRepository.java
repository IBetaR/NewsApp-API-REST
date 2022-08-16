package com.informatorio2022.ibrnewsapp.persistence.repository;

import com.informatorio2022.ibrnewsapp.persistence.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface AuthorRepository extends BaseRepository<Author, Long>{

    List<Author> findByFirstnameContainingOrLastnameContaining(String firstname, String lastname);
    Page<Author> findByFirstnameContainingOrLastnameContaining(String firstname, String lastname, Pageable pageable);
//    List<Author> findByCreateDateAfter(ZonedDateTime createdDate);

}

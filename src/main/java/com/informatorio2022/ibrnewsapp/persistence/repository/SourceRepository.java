package com.informatorio2022.ibrnewsapp.persistence.repository;

import com.informatorio2022.ibrnewsapp.persistence.entity.Author;
import com.informatorio2022.ibrnewsapp.persistence.entity.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends BaseRepository <Source, Long>{

    List<Source> findByNameContainingOrCodeContaining(String name, String code);
    Page<Source> findByNameContainingOrCodeContaining(String name, String code, Pageable pageable);
}

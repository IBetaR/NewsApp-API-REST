package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.entity.Source;
import com.informatorio2022.ibrnewsapp.persistence.repository.BaseRepository;
import com.informatorio2022.ibrnewsapp.persistence.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceServiceImpl extends BaseServiceImpl<Source, Long> implements SourceService{

    @Autowired
    private SourceRepository sourceRepository;

    public SourceServiceImpl(BaseRepository<Source, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Source> search(String search) throws Exception{
        try {
            List<Source> sources = sourceRepository.findByNameContainingOrCodeContaining(search,search);
            //List<Article> articles = articleRepository.search(search);
            //List<Article> articles = articleRepository.searchNative(search);
            return sources;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Source> search(String search, Pageable pageable) throws Exception {
        try {
            Page<Source> sources = sourceRepository.findByNameContainingOrCodeContaining(search,search, pageable);
            //Page<Article> articles = articleRepository.search(filter, pageable);
            //Page<Article> articles = articleRepository.searchNative(filter, pageable);
            return sources;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

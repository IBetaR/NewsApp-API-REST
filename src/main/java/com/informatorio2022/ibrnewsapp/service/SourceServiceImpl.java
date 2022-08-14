package com.informatorio2022.ibrnewsapp.service;

import com.informatorio2022.ibrnewsapp.persistence.entity.Source;
import com.informatorio2022.ibrnewsapp.persistence.repository.BaseRepository;
import com.informatorio2022.ibrnewsapp.persistence.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceServiceImpl extends BaseServiceImpl<Source, Long> implements SourceService{

    @Autowired
    private SourceRepository sourceRepository;

    public SourceServiceImpl(BaseRepository<Source, Long> baseRepository) {
        super(baseRepository);
    }
}

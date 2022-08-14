package com.informatorio2022.ibrnewsapp.controller;

import com.informatorio2022.ibrnewsapp.persistence.entity.Source;
import com.informatorio2022.ibrnewsapp.service.SourceServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/newsapp/sources")
public class SourceController extends BaseControllerImpl<Source, SourceServiceImpl>{
}

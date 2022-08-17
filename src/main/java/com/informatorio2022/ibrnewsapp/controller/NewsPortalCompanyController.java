package com.informatorio2022.ibrnewsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*")
public class NewsPortalCompanyController {

    @RequestMapping("/api/v1/newsapp/")
    public @ResponseBody String greeting(){
        return "Bienvenido A NewsApp API REST";
    }

}
package com.informatorio2022.ibrnewsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsPortalCompanyController {

    @RequestMapping("/")
    public @ResponseBody String greeting(){
        return "Hello";
    }
}

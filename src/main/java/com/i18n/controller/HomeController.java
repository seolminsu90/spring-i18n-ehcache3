package com.i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.i18n.repository.LanguageRepository;
import com.i18n.repository.TestRepository;

@Controller
public class HomeController {
    @Autowired
    LanguageRepository languageRepository;
    
    @Autowired
    TestRepository testRepository;
    
    @RequestMapping("/")
    public String welcome(ModelMap model) {
        model.addAttribute("test", "Hello world !!");   
        return "index";
    }
}

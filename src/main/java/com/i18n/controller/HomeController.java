package com.i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.i18n.entity.Member;
import com.i18n.repository.LanguageRepository;
import com.i18n.repository.TestRepository;
import com.i18n.service.CacheService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    @Autowired
    CacheService cacheService;

    @GetMapping("/member/nocache/{name}")
    @ResponseBody
    public Member getNoCacheMember(@PathVariable String name) {

        long start = System.currentTimeMillis(); // 수행시간 측정
        Member member = cacheService.findByNameNoCache(name); // db 조회
        long end = System.currentTimeMillis();

        log.info(name + "의 NoCache 수행시간 : " + Long.toString(end - start));

        return member;
    }

    @GetMapping("/member/cache/{name}")
    @ResponseBody
    public Member getCacheMember(@PathVariable String name) {

        long start = System.currentTimeMillis(); // 수행시간 측정
        Member member = cacheService.findByNameCache(name); // db 조회
        long end = System.currentTimeMillis();

        log.info(name + "의 Cache 수행시간 : " + Long.toString(end - start));

        return member;
    }

    @GetMapping("/member/refresh/{name}")
    @ResponseBody
    public String refresh(@PathVariable String name) {
        cacheService.refresh(name); // 캐시제거
        return "cache clear!";
    }
}

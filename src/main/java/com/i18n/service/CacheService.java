package com.i18n.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.i18n.entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CacheService {
    public Member findByNameNoCache(String name) {
        slowQuery(2000);
        return new Member(name);
    }

    @Cacheable(value = "findMemberCache", key = "#name")
    public Member findByNameCache(String name) {
        slowQuery(2000);
        return new Member(name);
    }

    @CacheEvict(value = "findMemberCache", key = "#name")
    public void refresh(String name) {
        log.info(name + "의 Cache Clear!");
    }

    private void slowQuery(long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}

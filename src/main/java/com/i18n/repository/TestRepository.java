package com.i18n.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.i18n.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Integer>{

}

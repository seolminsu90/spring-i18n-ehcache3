package com.i18n.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Cacheable
@Entity
@Table(name = "test")
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TestEntity {
    @Id
    private Integer id;
    
    @Column
    private String name;
}

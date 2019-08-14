package com.i18n.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.i18n.entity.LanguageEntity;
import com.i18n.entity.LanguageEntityId;

public interface LanguageRepository extends JpaRepository<LanguageEntity, LanguageEntityId> {
}

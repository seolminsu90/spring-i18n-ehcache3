package com.i18n.config;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import com.i18n.entity.LanguageEntity;
import com.i18n.entity.LanguageEntityId;
import com.i18n.repository.LanguageRepository;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {
    @Autowired
    private LanguageRepository languageRepository;
    private static final String DEFAULT_LOCALE_CODE = "en";

    @Override
    protected MessageFormat resolveCode(String key, Locale locale) {
        Optional<LanguageEntity> message = languageRepository.findById(new LanguageEntityId(key, locale.getLanguage()));
        if (!message.isPresent()) {
            message = languageRepository.findById(new LanguageEntityId(key, DEFAULT_LOCALE_CODE));
        }

        if (!message.isPresent()) {
            return null;
        } else {
            return new MessageFormat(message.get().getContent(), locale);
        }
    }
}

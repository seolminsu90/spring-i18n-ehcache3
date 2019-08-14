package com.i18n.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
public class LanguageEntityId implements Serializable {
    private static final long serialVersionUID = -3203548315448677321L;

    @Getter
    private String messagekey;
    @Getter
    private String locale;

    public LanguageEntityId() {
    }

    public LanguageEntityId(String messagekey, String locale) {
        this.messagekey = messagekey;
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LanguageEntityId))
            return false;
        LanguageEntityId that = (LanguageEntityId) o;
        return Objects.equals(getMessagekey(), that.getMessagekey()) && Objects.equals(getLocale(), that.getLocale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessagekey(), getLocale());
    }
}

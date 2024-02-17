package com.lecode.eduback.common;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @Autowired
  private MessageSource messageSource;

  public String getProperty(String code) {
    return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
  }

  public String getPropertyWithArgs(String code, Object... args) {
    return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
  }

  public String getProperty(String code, String defaultMessage) {
    return messageSource.getMessage(code, null, defaultMessage, LocaleContextHolder.getLocale());
  }

  public String getProperty(String code, Locale locale) {
    return messageSource.getMessage(code, null, locale);
  }

  public MessageSource getMessageSource() {
    return messageSource;
  }

  public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }
}

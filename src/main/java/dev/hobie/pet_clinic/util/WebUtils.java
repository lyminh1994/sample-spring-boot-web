package dev.hobie.pet_clinic.util;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;

@Component
public class WebUtils {

  public static final String MSG_SUCCESS = "MSG_SUCCESS";
  public static final String MSG_INFO = "MSG_INFO";
  public static final String MSG_ERROR = "MSG_ERROR";
  private static MessageSource messageSource;
  private static LocaleResolver localeResolver;

  public WebUtils(final MessageSource messageSource, final LocaleResolver localeResolver) {
    WebUtils.messageSource = messageSource;
    WebUtils.localeResolver = localeResolver;
  }

  public static HttpServletRequest getRequest() {
    if (RequestContextHolder.getRequestAttributes()
        instanceof ServletRequestAttributes requestAttributes) {
      return requestAttributes.getRequest();
    }

    return null;
  }

  public static String getMessage(final String code, final Object... args) {
    var request = getRequest();
    if (request != null) {
      return messageSource.getMessage(code, args, code, localeResolver.resolveLocale(request));
    }

    return messageSource.getMessage(code, args, code, Locale.ENGLISH);
  }
}

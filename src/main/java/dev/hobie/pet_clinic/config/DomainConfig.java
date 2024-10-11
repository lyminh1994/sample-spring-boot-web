package dev.hobie.pet_clinic.config;

import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration(proxyBeanMethods = false)
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
public class DomainConfig {

  @Bean("auditingDateTimeProvider")
  public DateTimeProvider dateTimeProvider() {
    return () -> Optional.of(OffsetDateTime.now());
  }
}

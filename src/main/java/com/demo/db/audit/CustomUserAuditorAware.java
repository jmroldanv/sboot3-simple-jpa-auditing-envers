package com.demo.db.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * This class is used to provide the current user of the application because of no Spring Security.
 */
@Component
public class CustomUserAuditorAware implements AuditorAware<String> {

    private static final String MOCK_USER = "mock_user_" + (int)(Math.random() * 100);

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(MOCK_USER);
    }
}

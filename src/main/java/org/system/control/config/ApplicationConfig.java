package org.system.control.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.system.control.dto.Limit;

@Configuration
public class ApplicationConfig {
    @Value("${org.system.control.room-limit}")
    private int roomLimit;
    @Value("${org.system.control.user-limit}")
    private int userLimit;

    @Bean
    public Limit getLimit() {
        return new Limit(roomLimit, userLimit);
    }
}

package com.collaborate.core.config;


import com.collaborate.core.filter.TraceRequestLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceConfig {


    @Bean
    public TraceRequestLoggingFilter traceRequestLoggingFilter() {
        return new TraceRequestLoggingFilter();
    }
}

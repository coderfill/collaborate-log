package com.collaborate.core.filter;

import org.slf4j.MDC;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class TraceRequestLoggingFilter extends AbstractRequestLoggingFilter {

    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String s) {
        String requestId = UUID.randomUUID().toString().replace("-", "");
        MDC.put("requestId", requestId);
    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String s) {
        MDC.remove("requestId");
    }
}

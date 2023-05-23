package com.collaborate.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class DemoService {

    private final static Logger logger = LoggerFactory.getLogger(DemoService.class);

    public void demo() {
        String requestId = MDC.get("requestId");
        new Thread(() -> {
            MDC.put("requestId", requestId);
            logger.info("service demo......");
        }).start();
    }
}

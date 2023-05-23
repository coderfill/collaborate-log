package com.collaborate.demo.controller;

import com.collaborate.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/log")
public class DemoController {

    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);


    @Resource
    private DemoService service;


    @RequestMapping("/demo")
    public void demo() {
        logger.info("demo....");
        service.demo();
    }
}

package com.springboot.microservices.camelmicroservicesource.components;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class LoggingProcessing {


    private Logger logger = LoggerFactory.getLogger(LoggingProcessing.class);

    public void process(String message) {

        logger.info("LoggingProcessing {}", message);

    }
}

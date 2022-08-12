package com.springboot.microservices.camelmicroservicesource.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLoggingProcessor implements Processor {

    private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getMessage().setHeader("header1", "dummyHeader");
        logger.info("SimpleLoggingProcessor exchange body {}", exchange.getMessage().getBody());
        logger.info("SimpleLoggingProcessor default headers {}", exchange.getMessage().getHeaders());
    }
}

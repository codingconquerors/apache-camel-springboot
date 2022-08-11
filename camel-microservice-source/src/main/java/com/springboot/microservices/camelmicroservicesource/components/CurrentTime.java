package com.springboot.microservices.camelmicroservicesource.components;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CurrentTime {

    public String getCurrentTime() {
        return "Time now is" + LocalDateTime.now();
    }
}

package com.springboot.microservices.camelmicroservicesource.routes;

import com.springboot.microservices.camelmicroservicesource.components.CurrentTime;
import com.springboot.microservices.camelmicroservicesource.components.LoggingProcessing;
import com.springboot.microservices.camelmicroservicesource.processor.SimpleLoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MyFirstRouter extends RouteBuilder {
    /**
     * <b>Called on initialization to build the routes using the fluent builder syntax.</b>
     * <p/>
     * This is a central method for RouteBuilder implementations to implement the routes using the Java fluent builder
     * syntax.
     *
     * @throws Exception can be thrown during configuration
     */

    @Autowired
    CurrentTime currentTime;

    @Autowired
    LoggingProcessing loggingProcessing;

    @Override
    public void configure() throws Exception {

        // step 1. timer
        // step 2. transformation
        // step 3. log
        from("timer:first-timer") // starting point of a route
                //Specify the constant expression value. Important: this is a fixed constant value that is only set once during starting up the route, do not use this if you want dynamic values during routing
                // .transform().constant("time now is "+ LocalDateTime.now())
                //.bean(currentTime) // transforming

                .log("${body}") // processing
                .bean(currentTime, "getCurrentTime") // with method name
               // .log("${body}")
                //.to("log:first-timer")
                .bean(loggingProcessing) // logging through bean

                // Adds the custom processor to this destination which could be a final destination,
                // or could be a transformation in a pipeline
                .process(new SimpleLoggingProcessor())  //invocation of a processor
                .log("${body}")
        ;

      /*  from("timer://simpleTimer?period=1000")
                .setBody(simple("Timer is at ${header.firedTime}"))
                .to("stream:out");*/

        // 2 types of operations we can do with in each route
        // 1. processing : if msg body is not changed
        // 2. transformation : if we are changing msg body

    }
}

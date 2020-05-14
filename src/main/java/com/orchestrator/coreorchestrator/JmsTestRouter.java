package com.orchestrator.coreorchestrator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JmsTestRouter extends RouteBuilder {

    static final org.slf4j.Logger log = LoggerFactory.getLogger(JmsTestRouter.class);

    @Override
    public void configure() throws Exception {
        from("activemq:TransactionsMap")
          .log(LoggingLevel.DEBUG, log, "New message received")
          .multicast()
          .to("direct:a","direct:b","direct:c")
          .process(exchange -> {
              String convertedMessage = exchange.getMessage().getBody() + " is converted";
              exchange.getMessage().setBody(convertedMessage);
          })
          .to("activemq:Orchestrator")
          .log(LoggingLevel.DEBUG, log, "Message is successfully sent to the output queue")
        .end();

    }
}

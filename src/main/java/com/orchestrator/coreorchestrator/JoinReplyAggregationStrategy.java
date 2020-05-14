package com.orchestrator.coreorchestrator;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import common.FinancialTransaction;
import common.ServiceResponse;

public class JoinReplyAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange exchange1, Exchange exchange2) {
        if (exchange1 == null) {
            return exchange2;
        } else {
            FinancialTransaction ft1= exchange1.getIn().getBody(FinancialTransaction.class);
            ServiceResponse ft2= exchange1.getIn().getBody(ServiceResponse.class);
            exchange1.getIn().setBody(ft1);
            return exchange1;
        }
    }

}

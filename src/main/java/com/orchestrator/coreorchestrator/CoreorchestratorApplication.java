package com.orchestrator.coreorchestrator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;

//import com.hazelcast.core.Hazelcast;
//import com.hazelcast.core.HazelcastInstance;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;


@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)
//@ImportResource({"classpath:camel-hazelcast.xml"})

public class CoreorchestratorApplication {

	
	public static void main(String[] args) {

		HazelcastInstance hazelcastInstance=Hazelcast.newHazelcastInstance();
  
		hazelcastInstance.getQueue("TransactionsQueue").addItemListener(new MyQueueListener(), true);
		SpringApplication.run(CoreorchestratorApplication.class, args);
	}
	
	

}

package com.orchestrator.coreorchestrator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;

//import com.hazelcast.core.Hazelcast;
//import com.hazelcast.core.HazelcastInstance;



@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)
//@ImportResource({"classpath:camel-hazelcast.xml"})

public class CoreorchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreorchestratorApplication.class, args);
	}
	
	

}

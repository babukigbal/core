package com.orchestrator.coreorchestrator;

import org.springframework.stereotype.Component;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

import common.FinancialTransaction;

@Component
public class MyQueueListener implements  ItemListener<Object> {
	HazelcastInstance hazelcastInstance;

	MyQueueListener(){

		System.out.println("Constructor MyQueueListener");
		this.hazelcastInstance=Hazelcast.newHazelcastInstance();
	}
@Override
public void itemAdded(ItemEvent<Object> item) {
	System.out.println(item.getItem().toString());
	IMap<String, FinancialTransaction> transactionMap=this.hazelcastInstance.getMap("TransactionsMap");
	FinancialTransaction financialTransaction=transactionMap.get(item.getItem());
	System.out.println("Core Orchestrator Financial Transaction " + financialTransaction.toString());
	IQueue<String> transactionsQueue=this.hazelcastInstance.getQueue("Service1Queue");
	transactionsQueue.add(item.getItem().toString());
	IQueue<String> transactions2Queue=this.hazelcastInstance.getQueue("Service2Queue");
	transactions2Queue.add(item.getItem().toString());
}

@Override
public void itemRemoved(ItemEvent<Object> item) {
	// TODO Auto-generated method stub
	
}


}

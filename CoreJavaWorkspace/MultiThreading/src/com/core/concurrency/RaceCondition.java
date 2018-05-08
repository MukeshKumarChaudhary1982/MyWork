package com.core.concurrency;

import com.core.concurrency.model.LongWrapper;

public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {
		
		LongWrapper longWrapper=new LongWrapper(0L);
		
		Runnable runnable=() ->{
			
			for(int i=0;i< 1_000;i++) {
				
				longWrapper.incrementValue();
			}
			
		};
		
		//Running in Single Thread- No issue
		/*Thread t=new Thread(runnable);
		t.start();
		
		System.out.println("Long Wrapper Value after 1000 increments"+longWrapper.getL());
		t.join();
		System.out.println("Long Wrapper Value after 1000 increments"+longWrapper.getL());
		*/
		
		//Run in multiple threads
		Thread[] threads=new Thread[10];
		for(int j=0;j<threads.length;j++) {			
			threads[j]=new Thread(runnable);
			threads[j].start();
		}
		for(int j=0;j<threads.length;j++) {	
			threads[j].join();
		}
		
		System.out.println("Long Wrapper Value after 1000 increments in 50 threads"+longWrapper.getL());

	}

}

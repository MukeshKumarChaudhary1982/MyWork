package com.core.concurrency;

public class RunnableDemo {

	public static void main(String[] args) {
		System.out.println("Inisde Main "+Thread.currentThread().getName() +Thread.currentThread().getId());
		
		Runnable runnable=new Runnable() {			
			@Override
			public void run() {
				System.out.println("Inside Thread "+Thread.currentThread().getName()+Thread.currentThread().getId());
				
			}
		};
		
		Runnable runnableLambda=() ->{
			System.out.println("Inside Thread "+Thread.currentThread().getName()+Thread.currentThread().getId());
			};
		
		Thread userThread=new Thread(runnable, "Userthread");
		userThread.start();
		Thread userThreadLambda=new Thread(runnableLambda, "UserthreadLambda");
		userThreadLambda.start();


	}

}

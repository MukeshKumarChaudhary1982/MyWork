package com.core.concurrency;

import com.core.concurrency.model.DeadlockModel;

public class DeadlockDemo {

	public static void main(String[] args) throws InterruptedException {

		DeadlockModel model=new DeadlockModel();
		
		Runnable r1=() -> model.a();
		Runnable r2=() -> model.b();

		Thread t1=new Thread(r1);
		t1.start();
		
		Thread t2=new Thread(r2);
		t2.start();
		
		t1.join();
		t2.join();
	}

}

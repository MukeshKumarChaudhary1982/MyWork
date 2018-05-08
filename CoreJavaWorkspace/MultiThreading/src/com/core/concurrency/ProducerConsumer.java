package com.core.concurrency;

public class ProducerConsumer {
	
	public static int[] buffer;
	public static int count;
	
	private static Object lock=new Object();
	
	static class Producer {
		
		void produce() {
			System.out.println("Trying Producing "+count);
			synchronized (lock) {
			if(isFull(buffer)) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				buffer[count++]=1;
				System.out.println("Producing "+count);
				lock.notify();
			}
			}
		}

	static class Consumer{
		void consume() {
			System.out.println("Trying Consuming "+count);
			synchronized (lock) {
			if(isEmpty(buffer)) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
				buffer[--count]=0;
				System.out.println("Consuming "+count);
				lock.notify();
			}
		}
	}
	
	public static boolean isEmpty(int[] buffer2) {
		return count==0;
	}
	public static boolean isFull(int[] buffer2) {
		return count==buffer.length;
	}
	
	public static void main(String[] args) throws InterruptedException {
		buffer=new int[10];
		count=0;
		
		Producer producer=new Producer();
		Consumer consumer=new Consumer();
		
		Runnable producertask=()->{
			for(int i=0;i<50;i++) {
				producer.produce();
			}
		System.out.println("Producing Completed!");
		};
		Runnable consumertask=()->{
			for(int i=0;i<45;i++) {
				consumer.consume();
			}
		System.out.println("Consuming Completed!");
		};
		
		Thread consumerThread=new Thread(consumertask);
		Thread producerThread=new Thread(producertask);
		
		consumerThread.start();
		producerThread.start();
		
		consumerThread.join();
		producerThread.join();
		
		System.out.println("Data in the Buffer: "+count);
	}
	

}

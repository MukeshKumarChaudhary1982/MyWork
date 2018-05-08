package com.core.concurrency.model;

public class LongWrapper {
	
	private Object key=new Object();
	
	private Long l;

	public Long getL() {
		return l;
	}

	public LongWrapper(Long l) {
		super();
		this.l = l;
	}
	
	public void incrementValue() {
		
		synchronized (key) {
			l=l+1;	
		}
		
	}

}

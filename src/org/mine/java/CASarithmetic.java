
package org.mine.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CASarithmetic {

	private AtomicInteger atomicInteger = new AtomicInteger();
	private static Lock lock = new ReentrantLock();
//	private int i = 0;
	private Integer i = new Integer(0);
	public static void main(String[] args) {
		
//		lock.lock();
//		lock.lock();
		Thread tt = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.unlock();
			}
		});
		
		long start = System.currentTimeMillis();
		final CASarithmetic cas =  new CASarithmetic();
		List<Thread> ls = new ArrayList<Thread>();
		for(int i = 0; i < 1000; i++){
			Thread t = new Thread(new Runnable(){

				@Override
				public void run(){
					for(int j = 0; j < 1000; j++){
						cas.count();
						cas.CASCount();
//						code -> jvm -> memory -> cpu  
						
					}
				}
			});
			ls.add(t);
		}
		
		for(Thread t : ls){
			t.start(); 
		}
		for(Thread t : ls){
			try {
				t.join();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		
		System.out.println("cas.i = " + cas.i);
		System.out.println("cas.ctomicInteger.get() = " + cas.atomicInteger.get());
		System.out.println("end time is: " + (System.currentTimeMillis() - start));
	}
	protected void CASCount() {
		for(;;){
			int i = atomicInteger.get();
			boolean succ = atomicInteger.compareAndSet(i, i+1);
			if(succ){
				break;
			}
		}
	}
	
	protected void count() {
		this.i++;
		
//		increase(i+1);
		
//		Integer i = getI();
//		i = i+1;
//		setI(i);
	}
	
	public void increase(int i){
		
		
	}
	
	private synchronized void setI(Integer i){
		this.i = i;
	}

	private synchronized Integer getI(){
		return this.i;
	}
}

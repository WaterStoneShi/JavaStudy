
package org.mine.thread.support;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.locks.Lock;

import org.mine.thread.SharedSynchronizer;

public class UseShared {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
//		System.setOut(new PrintStream("d:/sa.txt"));

		for(int i = 0; i < 10; i++){
			Worker w = new Worker();
			new Thread(w, "t_"+i).start();
		}
		for(int i = 0; i < 10; i++){
			Thread.sleep(1000);
			System.out.println("**********");
		}
	}

	static class Worker implements Runnable{

		@Override
		public void run() {
			
			while(true){
				lock.lock();
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		}
		
	}
	
	final static Lock lock = new SharedSynchronizer();
}

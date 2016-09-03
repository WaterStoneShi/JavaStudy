
package org.mine.thread;

public class Synchronized {

	public static void main(String[] args){
		new Thread(new RunnableImpl(), "t-1").start();
		new Thread(new RunnableImpl(), "t-2").start();
	}
	
	public static void test(){
		synchronized(Thread.currentThread()){
			System.out.println(Thread.currentThread().getName() + " in ...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " out ...");
	}
	
	public synchronized void m(){
		
	}
	
	static class RunnableImpl implements Runnable{

		@Override
		public void run() {
			test();
		}
		
	}
}

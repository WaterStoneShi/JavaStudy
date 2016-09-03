
package org.mine.thread;

import java.util.concurrent.locks.ReentrantLock;

public class UserReentrantLock {

	private static ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		new Thread(new RunnableImpl(), "t_1").start();
		new Thread(new RunnableImpl(), "t_2").start();
		new Thread(new RunnableImpl(), "t_3").start();
	}

	static class RunnableImpl implements Runnable{

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " come in ...");
			lock.lock();
			System.out.println(threadName + " is locking ...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
			lock.unlock();
			System.out.println(threadName + " unlocked ...");
		}
	}

}

package org.java.util.concurrent.Thread.Synchronous;

import java.util.concurrent.BrokenBarrierException;

/**
 * <p>
 * 屏障<br/>
 * 此类提供的功能，通俗的讲就是，将一个任务分为多个小功能分发给多个线程执行，
 * 但是线程执行的快慢是不可预测的，使用该类就可以让执行快的线程在某个'咖啡馆'等待其他执行慢的线程兄弟
 * 直到所有的线程兄弟全部到达
 * <P>
 * Java Api: {@link java.util.concurrent.CyclicBarrier}
 * 
 * <p>
 * <ul>
 * <li>实例化该类时可以指定参与者个数，以及所有参与者到达'咖啡馆'后要做的工作 ：{@link java.util.concurrent.CyclicBarrier#CyclicBarrier(int, Runnable)}
 * <li>执行快的线程可以调用 {@link java.util.concurrent.CyclicBarrier#await()} 方法等待其他执行慢的线程，直到最后一个参与者到达，释放所有的线程
 * 	   并触发到达'咖啡馆'后的工作执行
 * </ul>
 */
public class CyclicBarrier {

	static int[] data = new int[2];

	static java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(2, new Runnable(){
		// 该操作会被最后一个到达的线程执行，只要指定的线程到达await方法，就会执行此run方法，
		// 并不是一定等待所有的线程执行完对应的run方法之后执行这个run方法
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " main run method in...");
			System.out.println("data = " + (data[0] + data[1]));
			System.out.println(Thread.currentThread().getName() + " main run method out...");
		}

	});
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(new RunnableImpl(), "t_1").start();
		new Thread(new RunnableImpl(), "t_2").start();

	}

	static class RunnableImpl implements Runnable{

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " in ...");
			if("t_1".equals(threadName))
				data[0] = 1;
			else
				data[1] = 2;
			
			try {
				CyclicBarrier.cyclicBarrier.await();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			} catch (BrokenBarrierException exception) {
				exception.printStackTrace();
			}

			System.out.println(threadName + " out ...");
		}

	}
}

package org.java.util.concurrent.Thread.Synchronous;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 信号量<br/>
 * 此类提供的处理方式类似于银行柜员接待客户处理业务
 * <p>
 * Java Api: {@link java.util.concurrent.Semaphore}
 * <p>
 * <ul>
 * <li> 在创建实例时，你可以指定'柜员'的数目，以及柜员的是否公平的按先来后到【FIFO】的规则处理顺序:
 *      {@link java.util.concurrent.Semaphore#Semaphore(int, boolean)}
 * <li> 客户到达之后可以可以尝试获取一个柜员的处理{@link java.util.concurrent.Semaphore#tryAcquire(long, java.util.concurrent.TimeUnit)}，
 *      要是暂时没有空闲的柜员，客户可以设定等待时间，要是超过了等待时间还没有空闲柜员的话，这个客户就会放弃在该'网点'办理业务
 * </ul>
 */
public class Semaphore {

	static java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(2, true);
	
	public static void main(String[] args) {
		new Thread(new RunnableImpl(), "t_1").start();
		new Thread(new RunnableImpl(), "t_2").start();
		new Thread(new RunnableImpl(), "t_3").start();
	}
	
	static class RunnableImpl implements Runnable{

		@Override
		public void run() {
			
			boolean ava = false;
			try {
				System.out.println(Thread.currentThread().getName() + " in..");
				ava = semaphore.tryAcquire();
				System.out.println(Thread.currentThread().getName() + ava);
//				Thread.sleep(3000);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			
			if(ava){
				System.out.println(Thread.currentThread().getName() + " success");
			}else{
				System.out.println(Thread.currentThread().getName() + " fail");
			}
			semaphore.release();
		}
		
	}
}
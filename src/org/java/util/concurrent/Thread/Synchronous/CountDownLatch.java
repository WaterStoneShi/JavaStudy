
package org.java.util.concurrent.Thread.Synchronous;

/**
 * <p>
 * 倒计数闭锁<br/>
 * 使用倒计数的方式，即直到计数器为零时，会释放所有等待中的线程
 * <p>
 * Java Api: {@link java.util.concurrent.CountDownLatch}
 * 
 * <p>
 * <ul>
 * <li>初始化该类时会初始化一个计数器:{@link java.util.concurrent.CountDownLatch#CountDownLatch(int)}
 * <li>调用 {@link java.util.concurrent.CountDownLatch#await()} 方法使当前线程处于堵塞状态，直到计数器为0时
 * 	        所有的堵塞线程被释放
 * <li> 调用 {@link java.util.concurrent.CountDownLatch#countDown()} 方法使计数器递减1
 * </ul>
 * 
 * Page.438
 */
public class CountDownLatch {

	public static void main(String[] args) {

	}
}
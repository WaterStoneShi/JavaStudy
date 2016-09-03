
package org.java.util.concurrent.Thread.Pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Java Api: {@link java.util.concurrent.ScheduledExecutorService}
 * 
 * <ul>
 * <li>{@link java.util.concurrent.ScheduledExecutorService#schedule(java.util.concurrent.Callable, long, java.util.concurrent.TimeUnit)}
 *     该方法延迟执行指定的任务
 * <li>{@link java.util.concurrent.ScheduledExecutorService#scheduleAtFixedRate(Runnable, long, long, java.util.concurrent.TimeUnit)}
 *     该方法按照某个周期执行，第一次执行在延迟时间后，以后的执行在'延迟+周期'后执行,<br/>
 *     通过测试分为下列两中情况
 *     <ul>
 *     <li>若任务的执行时间大于间隔周期，则会等上一个任务结束之后，立即执行下一个任务
 *     <li>若任务的执行时间小于间隔周期则按照固定周期执行，即从上一个任务执行开始时计时，中间间隔一个周期【即例子中的5s】，然后执行下一个任务
 *     </ul>
 * <li>{@link java.util.concurrent.ScheduledExecutorService#scheduleWithFixedDelay(Runnable, long, long, java.util.concurrent.TimeUnit)}
 *     该方法与scheduleAtFixedRate的区别就是<b>从上一个任务执行结束之后开始计时，然后间隔一个周期【即例子中的5s】执行下一个任务</b>
 * </ul>
 * 
 */
public class ScheduledThreadPoolExecutor {

	public static void main(String[] args) {
		System.out.println(new Date());
		
		java.util.concurrent.ScheduledExecutorService scheduleExecutorService = Executors.newScheduledThreadPool(10);
//		scheduleWithFixedDelay(scheduleExecutorService);
		
		scheduleWithFixedRate(scheduleExecutorService);
	}

	public static void scheduleWithFixedRate(
			java.util.concurrent.ScheduledExecutorService scheduleExecutorService) {
		scheduleExecutorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "sleep before: " + new Date());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "sleep after: " + new Date());
			}
		}, 3, 5, TimeUnit.SECONDS);
	}

	public static void scheduleWithFixedDelay(
			java.util.concurrent.ScheduledExecutorService scheduleExecutorService) {
		scheduleExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "sleep before: " + new Date());
				try {
					Thread.sleep(6000);
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "sleep after: " + new Date());
			}
		}, 3, 5, TimeUnit.SECONDS);
	}

}

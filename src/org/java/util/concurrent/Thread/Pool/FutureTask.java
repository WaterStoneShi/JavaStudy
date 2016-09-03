
package org.java.util.concurrent.Thread.Pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>FutureTask是封装类, 实现了Future与Runnable接口，并提供了一种便捷的方法，可以将Callable转换为Future与Runnable
 */
public class FutureTask {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		java.util.concurrent.FutureTask<String> futureTask = 
				new java.util.concurrent.FutureTask<String>(new Callable<String>() {
					@Override
					public String call() throws Exception {
						System.out.println("====>");
						return "test";
					}
				});
//		futureTask.run();
		ExecutorService servie = Executors.newFixedThreadPool(1);
		java.util.concurrent.Future<String> future = (Future<String>) servie.submit(futureTask);
		
		// 会堵塞 why?
		System.out.println(future.isDone());
		System.out.println("<====");
	}
}


package org.java.util.concurrent.Thread.Pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.java.util.concurrent.Thread.Entity;

/**
 * <p>
 * 在ExecutorCompletionService类中take方法可以一个个的获取到任务执行的结果，如果没有任务，就会一直等待,不用等待所有任务执行完成
 * 而Future的get方法就会等待所有的任务执行完成，否则该方法一直处于阻塞状态
 */
public class ExecutorCompletionService {

	private static final int THREAD_SIZE = 10;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		java.util.concurrent.ExecutorService executorService = 
				Executors.newFixedThreadPool(THREAD_SIZE);
		List<Entity> tasks = new ArrayList<Entity>();
		tasks.add(new Entity("zhangsan"));
		tasks.add(new Entity("lisi"));
		tasks.add(new Entity("wangwu"));
		
		java.util.concurrent.ExecutorCompletionService<Entity> completionService = 
				new java.util.concurrent.ExecutorCompletionService<Entity>(executorService);
		
		for(Callable<Entity> task : tasks){
			completionService.submit(task);
		}
		
		Lock look = new ReentrantLock();
		
		for(int i = 0; i < tasks.size(); i++){
			look.lock();
			Entity entity = completionService.take().get();
			System.out.println(entity.getName());
			look.unlock();
		}
	}
}

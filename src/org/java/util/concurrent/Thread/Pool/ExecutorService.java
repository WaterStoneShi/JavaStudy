
package org.java.util.concurrent.Thread.Pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.java.util.concurrent.Thread.Entity;

public class ExecutorService {

	private static final int THREAD_SIZE = 10;
	
	public static void main(String[] args) {
		java.util.concurrent.ExecutorService executorService = 
				Executors.newFixedThreadPool(THREAD_SIZE);
		List<Entity> tasks = new ArrayList<Entity>();
		tasks.add(new Entity("zhangsan"));
		tasks.add(new Entity("lisi"));
		tasks.add(new Entity("wangwu"));
		try {
			List<Future<Entity>> invokeRs = executorService.invokeAll(tasks);
			for(Future<Entity> future: invokeRs){
				System.out.println(future.get().getName());
			}
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		} catch (ExecutionException exception) {
			exception.printStackTrace();
		}
	}
}

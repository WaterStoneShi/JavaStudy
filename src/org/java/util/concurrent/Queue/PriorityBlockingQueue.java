
package org.java.util.concurrent.Queue;

import java.util.Comparator;

/**
 * <p> 无界阻塞队列 <br/>
 * Java Api: {@link java.util.concurrent.PriorityBlockingQueue}
 * 
 * <P>
 * 该队列提供元素排序功能
 */
public class PriorityBlockingQueue {

	public static void main(String[] args) {
		java.util.concurrent.PriorityBlockingQueue<String> priorityBlockingQueue = 
				new java.util.concurrent.PriorityBlockingQueue<String>(2);
		priorityBlockingQueue.add("a");
		priorityBlockingQueue.add("b");
		System.out.println(priorityBlockingQueue.peek());
		priorityBlockingQueue.add("c");
		System.out.println(priorityBlockingQueue.size());
		System.out.println("\n");
		java.util.concurrent.PriorityBlockingQueue<String> priorityBlockingQueue2 = 
				new java.util.concurrent.PriorityBlockingQueue<String>(2, new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						return o2.compareTo(o1);
					}
				});
		priorityBlockingQueue2.add("a");
		priorityBlockingQueue2.add("d");
		priorityBlockingQueue2.add("b");
		System.out.println(priorityBlockingQueue2.peek());
	}
}
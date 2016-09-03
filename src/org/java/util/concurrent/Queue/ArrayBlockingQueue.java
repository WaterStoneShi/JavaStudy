
package org.java.util.concurrent.Queue;

/**
 * <p>数组支持的阻塞队列
 * Java Api: {@link java.util.concurrent.ArrayBlockingQueue}
 *
 * <p>
 * <ul>
 * <li>{@link java.util.concurrent.ArrayBlockingQueue#peek()}: <br/>
 *     &nbsp;&nbsp;获取队列此队列的头，但不会从此队列中移除，若队列为空，则返回null 
 * </ul>
 */
public class ArrayBlockingQueue {

	public static void main(String[] args) {
		java.util.concurrent.ArrayBlockingQueue<String> arrayBlockingQueue = new java.util.concurrent.ArrayBlockingQueue<String>(2);
		arrayBlockingQueue.add("a");
		arrayBlockingQueue.add("b");
		String rs = arrayBlockingQueue.peek();
		System.out.println(rs + "==>" + arrayBlockingQueue.size());
	}
}
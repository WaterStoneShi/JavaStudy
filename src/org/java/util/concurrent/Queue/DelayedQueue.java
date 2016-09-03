
package org.java.util.concurrent.Queue;

import java.util.concurrent.DelayQueue;

/**
 * 
 * 按照元素的延迟时间进行排序，延迟时间就是在元素从队列中移除走之前剩余的时间<br/>
 * 一个无界阻塞队列，只有在延迟期满时才能从中提取元素。该队列的头部 是延迟期满后保存时间最长的 Delayed 元素。
 * 如果延迟都还没有期满，则队列没有头部，并且 poll 将返回 null
 * 
 */
public class DelayedQueue {

	public static void main(String[] args) {
		DelayQueue<DelayedExt> delayedQueue = new DelayQueue<DelayedExt>();
		DelayedExt delay_1 = new DelayedExt(50000);
		System.out.println("delay_1 => " + delay_1);
		DelayedExt delay_2 = new DelayedExt(100000);
		System.out.println("delay_2 => " + delay_2);
		DelayedExt delay_3 = new DelayedExt(300000);
		System.out.println("delay_3 => " + delay_3);
		delayedQueue.add(delay_1);
		delayedQueue.add(delay_2);
		delayedQueue.add(delay_3);
		System.out.println(delayedQueue.peek());
	}
}
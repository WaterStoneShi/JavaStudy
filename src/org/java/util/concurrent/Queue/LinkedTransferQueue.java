
package org.java.util.concurrent.Queue;
/**
 * JavaSE 7之后添加的操作，补充同步队列
 * {@link java.util.concurrent.SynchronousQueue}
 * 
 * <p>
 * <ul>
 * <li><code>transfer</code> 方法阻塞调用，等待接收者接收
 * <li><code>tryTransfer</code> 方法具有可选的超时功能的非阻塞调用
 * <li><code>getWaitingConsumerCount</code> 方法返回等待接收元素【<code>take</code>、<code>poll</code>】的消费者的估计个数
 * <li><code>hasWaitingConsumer</code> 方法测试是否存在等待接收元素的消费者
 * </ul>
 */
public class LinkedTransferQueue {

	public static void main(String[] args) {

	}
}

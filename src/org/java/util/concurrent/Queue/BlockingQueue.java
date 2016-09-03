
package org.java.util.concurrent.Queue;

/**
 * <p> 阻塞队列
 * Java Api: {@link java.util.concurrent.BlockingQueue}
 * 
 * <p>
 * <ul>
 * <li> 抛异常操作:
 *  <ul>
 *   <li>{@link java.util.concurrent.BlockingQueue#add(Object)}: <br/>
 *   	 将指定元素插入此队列中（如果立即可行且不会违反容量限制），
 *       成功时返回 true，如果当前没有可用的空间，则抛出 IllegalStateException
 *   <li>{@link java.util.concurrent.BlockingQueue#remove(Object)}: 
 *  </ul>
 * <li> 阻塞操作:
 *  <ul>
 *   <li>{@link java.util.concurrent.BlockingQueue#put(Object)}: 
 *   <li>{@link java.util.concurrent.BlockingQueue#take(Object)}: 
 *  </ul>
 * 
 * <li> 返回特殊值操作:
 *  <ul>
 *   <li>{@link java.util.concurrent.BlockingQueue#offer(Object)}: 
 *   <li>{@link java.util.concurrent.BlockingQueue#poll(Object)}: 
 *  </ul>
 * </ul>
 * 
 * {@link java.util.concurrent.BlockingQueue#drainTo(java.util.Collection)}:<br/>
 * 此方法移除队列中的所有元素，并将所有的元素添加到指定的collection中
 * <p><b>注意：</b>
 * <ul><li>BlockingQueue 不接受 null 元素</ul>
 */
public interface BlockingQueue {

}

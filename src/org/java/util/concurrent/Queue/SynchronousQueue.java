
package org.java.util.concurrent.Queue;

/**
 * 同步队列
 * Java Api: {@link java.util.concurrent.SynchronousQueue}
 * 
 * <p><b>注意：</b><ul>
 * <li>同步队列没有任何内部容量，甚至连一个队列的容量都没有
 * <li>add和remove操作会报异常
 * <li>
 * </ul>
 */
public class SynchronousQueue {

	private static java.util.concurrent.SynchronousQueue<String> SYNCHRONOUSQUEUE = null;
	public static void main(String[] args) throws InterruptedException {
		SYNCHRONOUSQUEUE = 
				new java.util.concurrent.SynchronousQueue<String>(true);
		new Thread(new TT()).start();
		Thread.sleep(3000);
		// 此队列恰好被取走的时候该操作返回true,否则返回false;
		System.out.println(SYNCHRONOUSQUEUE.offer("a"));
		// 在被出走之前，此操作一致处于阻塞状态
		SYNCHRONOUSQUEUE.put("a");
		System.out.println("put over");
	}

	private static class TT implements Runnable {
		public void run() {
			while(true){
				try {
					System.out.println("run~~~");
					String rs = SYNCHRONOUSQUEUE.take();
					if(null != rs){
						System.out.println(rs);
						break;
					}
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}

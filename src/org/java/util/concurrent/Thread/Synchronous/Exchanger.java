
package org.java.util.concurrent.Thread.Synchronous;

import org.java.util.concurrent.Thread.Entity;

/**
 * <p> 交换器允许两个线程在某个同步点交换对象<br/>
 * Java Api: {@link java.util.concurrent.Exchanger}
 * 
 * <p>
 * Exchanger 可能被视为 SynchronousQueue 的双向形式
 */
public class Exchanger {

	public static void main(String[] args) throws InterruptedException {

		java.util.concurrent.Exchanger<Entity> exchanger = 
				new java.util.concurrent.Exchanger<Entity>();
		new Thread(new Exchanger.Register(new Entity("xiaoming"), exchanger)).start();
		Thread.sleep(3000);
		new Thread(new Exchanger.Register(new Entity("xiaoqiang"), exchanger)).start();
		System.out.println("It's over !!!");
//		Collections.synchronizedList(list);
	}

	private static class Register implements Runnable{

		private Entity entity;
		private java.util.concurrent.Exchanger<Entity> exchanger;
		public Register(Entity entity, java.util.concurrent.Exchanger<Entity> exchanger){
			this.entity = entity;
			this.exchanger = exchanger;
		}
		
		@Override
		public void run() {
			try {
				System.out.println("Before: " + Thread.currentThread().getName() + "==> " + this.entity.getName());
				entity = this.exchanger.exchange(entity);
				System.out.println("After: " + Thread.currentThread().getName() + "==> " + this.entity.getName());
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		
	}
	
	public class aa{
		
	}
}

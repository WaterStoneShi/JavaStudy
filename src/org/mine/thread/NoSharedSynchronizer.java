
package org.mine.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class NoSharedSynchronizer implements Lock{

	private final Sync sync = new Sync();
	
	/*************** Lock接口实现开始 ******************/
	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() { 
		return sync.newCondition();
	}
	/*************** Lock接口实现结束 ******************/

	
	/*************** 自定义方法实现开始 ******************/
	public boolean isLocked(){
		return sync.isHeldExclusively();
	}
	
	public boolean hasQueueThreads(){
		return sync.hasQueuedThreads();
	}
	/*************** 自定义方法实现结束 ******************/
	
	
	/************* 队列同步器开始 ***************/
	private static class Sync extends AbstractQueuedSynchronizer{
		
		@Override
		protected boolean isHeldExclusively() {
			// 是否处于占用状态
			return getState() == 1;
		}
		
		@Override
		protected boolean tryAcquire(int arg) {
			
			if(compareAndSetState(0, 1)){
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		
		@Override
		protected boolean tryRelease(int arg) {
			
			if(getState() == 0){
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
		
		Condition newCondition(){
			return new ConditionObject();
		}
	}
	/************* 队列同步器结束 ***************/
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new RunnableImpl(), "thread_1");
		t1.start();
		
		Thread.sleep(3000);
		
		System.out.println(new RunnableImpl().flag);
		
	}
	
	private static class RunnableImpl implements Runnable{
		private static volatile boolean flag;
		@Override
		public void run() {
			flag = true;
			System.out.println("flag set finished");
		}
		
	}
}


package org.mine.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SharedSynchronizer implements Lock{
	
	private final Sync sync= new Sync(2);

	@Override
	public void lock() {
		
		sync.tryAcquireShared(1);		
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		
		sync.acquireSharedInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		
		return sync.tryAcquireShared(1) > 0;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		
		return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		sync.tryReleaseShared(1);
	}

	@Override
	public Condition newCondition() {
		return null;
	}

	private static class Sync extends AbstractQueuedSynchronizer{
		
		Sync(int count){
			if(count < 0){
				throw new IllegalArgumentException("count must large than zero");
			}
			setState(count);
		}
		
		@Override
		protected int tryAcquireShared(int arg) {
			for(;;){
				int current = getState();
				int newCount = current - arg;
				// 例子中写法
				// if(newCount < 0 || compareAndSetState(current, newCount)){
				if(newCount >= 0 && compareAndSetState(current, newCount)){
					return newCount;
				}
			}
		}
		
		@Override
		protected boolean tryReleaseShared(int arg) {
			for(;;){
				int current = getState();
				int newcount = current + arg;
				if(compareAndSetState(current, newcount)){
					return true;
				}
			}
		}
	}
}

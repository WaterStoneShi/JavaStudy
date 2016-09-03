
package org.java.util.concurrent.Queue;

import java.util.Calendar;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedExt implements Delayed{

	private long delay;
	private long expire;
	public long getVal() {
		return delay;
	}

	public void setVal(long val) {
		this.delay = val;
	}

	public DelayedExt(long delay) {
		this.delay = delay;
		this.expire = this.delay + Calendar.getInstance().getTimeInMillis();
	}

	@Override
	public int compareTo(Delayed o) {
		return (int)(this.delay - o.getDelay(TimeUnit.MILLISECONDS));
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return (this.expire - Calendar.getInstance().getTimeInMillis());
	}
}
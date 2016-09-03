
package org.java.util.concurrent.Thread.Pool;

/**
 * <p> 当调用者将任务交给Executor时，Executor会返回Future对象给调用方 
 * 
 * Java Api: {@link java.util.concurrent.Future}
 * 
 * <p>
 * <ul>
 * <li>{@link java.util.concurrent.Future#get()} 方法会将结果返回给调用方，如果计算没有结束，get方法会一直等下去
 * <li>{@link java.util.concurrent.Future#isDone()} 方法检测任务是否执行结束，若结束则返回true
 * <li>{@link java.util.concurrent.Future#cancel(boolean)} 方法会在任务正常结束之前<b>尝试</b>进行取消，如果任务正常结束之前被取消，
 * {@link java.util.concurrent.Future#isCancelled()} 方法会返回true
 * </ul>
 */
public interface Future {

}

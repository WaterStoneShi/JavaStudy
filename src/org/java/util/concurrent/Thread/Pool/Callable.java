
package org.java.util.concurrent.Thread.Pool;
/**
 * <p>Callable接口类似于Runnable, 拥有接收单个参数的call方法
 * 
 * Java Api: {@link java.util.concurrent.Callable}
 * 
 * <p>
 * call方法与run方法的区别:<br/>
 * <ul>
 * <li>call方法会抛出异常;<br/>
 * <li>Callable<Object>会有返回值, Callable<void>可以实现没有返回值的Callable;
 * </ul>
 */
public interface Callable {

}

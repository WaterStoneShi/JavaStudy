
package org.java.util.concurrent.Thread.Synchronous;

/**
 * <p>移相器 拥有与<code>CyclicBarrier</code>和<code>CountDownLatch</code>类似的屏障功能<br/>
 *  且该屏障的参数者个数是可变的
 *  
 *  <p>
 *  <ul>
 *  <li><code>register</code> 赛马报名签到
 *  <li><code>arriveAndAwaitAdvance</code> 在围栏处等待比赛开始
 *  <li><code>arriveAndDeregister</code> 放开围栏比赛开始
 *  <li><code>getArrivedParties</code> 统计已经到达围栏准备比赛的马数
 *  <li><code>onAdvance</code>
 *  	<ul>
 *  	<li> 当每个阶段执行完毕后，此方法会被自动调用 ，相当于与<code>CyclicBarrier</code>的barrierAction
 *      <li> 没执行完一轮phase值加1
 *      <li> 当此方法返回true时，此Phaser被终止，所以可以通过控制返回值控制执行的多少轮
 *      </ul>
 *  </ul>
 *  <p><b>注意: </b>
 *  <ul>
 *  <li>Java Api 7中引入
 *  </ul>
 */
public class Phaser {

	public static void main(String[] args) {
		
	}

	
}

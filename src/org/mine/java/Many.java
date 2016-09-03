
package org.mine.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Many implements Runnable{

	public static void main(String[] args) throws InterruptedException {

//		testFd();
		
//		testThreadJoin();
		
		int i = 0;
		
		// 1、将i从局部变量加载到栈顶， i=0
		// 2、将局部变量表中的 i 加 1，局部变量中的i 变为1
		// 3、将栈顶的0 存回到局部变量表， i 变为 0
		i = i++;
		System.out.println(i);
	}

	public static void testThreadJoin() throws InterruptedException {
		Many many = new Many();
		Thread t = new Thread(many);
		t.start();
		System.out.println("t is already start");
		
		// join方法会等待该线程执行结束
		t.join();
		System.out.println("t.join() is executed");
	}

	public static void testFd() {
		// 浮点数计算
		// Bigdecimal(double)构造器的结果是不可预知的，Bigdecimal(String)的结果是可预知的，所以一般优先使用后者
		System.out.println(4.015*100.0);
		System.out.println(new BigDecimal(4.015).multiply(new BigDecimal(100)).doubleValue());
		System.out.println(new BigDecimal("4.015").multiply(new BigDecimal(100)).doubleValue());
		System.out.println(new BigDecimal(4.015).multiply(new BigDecimal("100")).doubleValue());
		System.out.println(BigDecimal.valueOf(4.015).multiply(BigDecimal.valueOf(100)).doubleValue());
		
	    // 四舍五入
		DecimalFormat df = new DecimalFormat("#.000");
		  // 默认使用的RoundingMode.EVEN,
		  // 即舍入部分的左边数字为奇数，则舍入行为同RoundingMode.HALF_UP
		  // 即舍入部分的左边数字为偶数，则舍入行为同RoundingMode.HALF_DOWN
//		df.setRoundingMode(RoundingMode.HALF_DOWN);
//		df.setRoundingMode(RoundingMode.HALF_UP);
		System.out.println(df.format(4.0576));
	}

	@Override
	public void run() {
		System.out.println("run method start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
		System.out.println("run method end");
	}

	
	
}

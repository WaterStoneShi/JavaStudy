
package org.mine.newcoder;

/**
 * 被final修饰的类成为最终类<br/>
 * 
 * 
 */
public class JavaTest_01 {

	
	public static void main(String[] args) {
//		q_01();
		q_02();

	}
	
	public static void q_01(){
		
		// the result is true
		// 基本数据类型赋值给包装类型时，会调用相应包装类型的XX.valueOf()
		Boolean flag = false;
		if(flag = true){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
	
	public static void q_02(){
		
		Thread t = new Thread(){
			// 重写Thread类的run方法
			public void run(){
				pong();
			}
		};
		t.run();
		System.out.println("ping");
	}
	
	public static void pong() {
		System.out.println("pong");
	}
}

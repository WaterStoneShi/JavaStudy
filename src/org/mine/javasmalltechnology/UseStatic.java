
package org.mine.javasmalltechnology;

/**
 * 静态代码块和静态成员变量按照声明的顺序初始化
 */
public class UseStatic {

	static{
		System.out.println("~~~~");
	}
	static int cnt = 6;
	static{
		cnt /= 3;
	}
	static{
		cnt += 9;
	}
	
	public static void main(String[] args) {

		System.out.println("cnt = " + cnt);
		
	}

}


package org.mine.javasmalltechnology;

/**
 * 隐式类型转换的规则是从低到高<br/>
 *   byte  short  char  int  long  float  double  
 * 	  1      2	 	2	 4	   8	 4		8
 * <p>
 * etc.黄种人是人类，但是人类不一定是黄种人
 * 
 * 
 * <p>
 * 在接口中方法只能被public修饰<br/>
 * 在抽象类中抽象方法abstract不可省，且可被除了private之外的为他三种修饰符修饰<br/>
 * 
 * native：表明该方法的实现在系统级别
 * abstract：表明该方法的实现在子类中
 * 
 */
public abstract class AutoSwitch {
	
	float func0(){
		byte i = 1;
		return i;
	}
	
	float func1(){
		int i = 1;
		return i;
	}
	
	float func2(){
		short i = 2;
		return i;
	}
	
	float func3(){
		long i = 3;
		return i;
	}
	
	/*float func4(){
		double i = 4;
		return i;  // 错误
	}*/
	
	public abstract void f0();
	protected abstract void f1();
	abstract void f2();
	
	interface UserMethod{
		
		public void f();
	}
}

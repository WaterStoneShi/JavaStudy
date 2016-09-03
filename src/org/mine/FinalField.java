
package org.mine;

/**
 * final 修饰引用变量，引用地址不变，但是里面的域可以改变
 * final 修饰的变量，不会被重排序到构造函数外，且final域的写于final的读不会被重排序
 */
public class FinalField {

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				writeOne();
				System.out.println("after writeOne: " + finalField);
			}
		}).start();
		
		Thread.sleep(1000);
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				writeTwo();
//			}
//		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				reader();
			}
		}).start();

		Thread.sleep(4000);
		reader();
	}
	
	private final int[] intArray;
	private static FinalField finalField;
	
	public FinalField(){
		System.out.println("FinalField Constract starting");
		System.out.println("this: " + this);
		finalField= this;
		intArray = new int[2];
		try {
			System.out.println("sleeping...");
			Thread.sleep(3000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
		intArray[0] = 1;
		System.out.println("FinalField Constract end");
	}
	
	private static void writeOne(){
		finalField = new FinalField();
	} 
	
	private static void writeTwo(){
		finalField.intArray[1] = 2;
	}
	
	private static void reader(){
		if(finalField != null){
			int a = finalField.intArray[0];
			System.out.println("reader: " + a);
		}else{
			System.out.println("Constract is not finished");
		}
	}

}

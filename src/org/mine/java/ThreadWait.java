
package org.mine.java;


public class ThreadWait {

	private static Object obj = new Object();
	private static ThreadWait tw;

	public static void main(String[] args) throws InterruptedException {
		tw = new ThreadWait();
		new Thread(new Runnable(){
			public void run(){
				tw.commonMethod();
			}
		}, "ThreadWait_2").start();
		new Thread(new Runnable(){
			public void run(){
				tw.commonMethod();
//				notifySelf();

			}
		}, "ThreadWait_2").start();

		Thread.sleep(3);
		synchronized(obj){
				obj.notifyAll();
		}
		//		Thread.sleep(3);
	}


	private void commonMethod(){
		System.out.println("common method coming...");
		synchronized(obj){

			System.out.println("synchronized block coming...");
			//			Thread.sleep(3000);
			try {
				obj.wait();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		System.out.println("commMethod ended...");
	}

	public static void notifySelf(){
		System.out.println("notify run...");
		obj.notify();
	}
}

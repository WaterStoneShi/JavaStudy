
package org.mine;

public class HappensBefore implements Runnable{

	private static Thread t1,t2;
	public static void main(String[] args) {
//		rule6();
		HappensBefore hb = new HappensBefore();
		HappensBefore hb1 = new HappensBefore();
		new Thread(hb).start();
		new Thread(hb1).start();
	}
	
	public void run(){
		synchronized(HappensBefore.class){
			System.out.println("Thread coming");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException exception)  { 
				exception.printStackTrace();
			} 
		}
	}
	
	
	/**
	 * 
	 */
	public static void rule6() {
		t1 = new Thread(new Runnable() {

			@Override
			public void run() { 
				System.out.println("Thread_1 sleeping");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
				System.out.println("Thread_1 sleep end");

			}
		});
		t1.start();

		t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread_1 joining...");		
				try {
					t1.join();
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
				System.out.println("Thread_1 join end");
				
			}
		});
		t2.start();
	}

}

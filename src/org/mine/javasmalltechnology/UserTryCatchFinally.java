
package org.mine.javasmalltechnology;

public class UserTryCatchFinally {

	public static void main(String[] args) {
		/*int data = 10;
		System.out.println(extreacted(data));*/
		System.out.println(tt(1));
	}

	@SuppressWarnings("finally")
	public static int extreacted(int data) {
		try {
			data += 10; // 20
			return --data; // 19 但是不会执行return
		} catch (Exception exception) {
		}finally{
			data += 10; // 29
			return --data; // 28 并且执行return
		}
	}
	
	public static int tt(int a){
		if(a == 1){
			try {
				throw new Exception();
			} catch (Exception exception) {
				a += 2;
				return a;
			}finally{
				a += 3;
				return a;
			}
		}
		a += 1;
		return a;
	}

}

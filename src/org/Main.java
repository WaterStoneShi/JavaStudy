
package org;

public class Main {
	static final int SHARED_SHIFT   = 16;
	static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
	static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
	static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
	public static void main(String[] args) {
		/*int a = 1;
		a -= 9-7;
		System.out.println(a);*/

		System.out.println(1<<16);
		System.out.println(0 & EXCLUSIVE_MASK);
//		System.out.println(0 & EXCLUSIVE_MASK);
	}

}


package org.mine.operationCharacter;

public class OperationalCharacter {

	public static void main(String[] args) {

		// ~ 按位非 (一元运算符)(NOT) ==> 0变为1 1变为0
		System.out.println(~(0xFFFFFFF1));
		System.out.println("~1 = " + ~1);
		System.out.println("~(-1) = " + ~(-1));

		// & 按位与(AND) ==> 两个都为1时才为1
		System.out.println("2 & 1 = " +(2&1));
		int a = 2;
		System.out.println("a &= 1 = " + (a &= 1));

		// | 按位或 (OR)==> 只要有1就是1
		System.out.println("2 | 1 = " + (2|1));
		int b = 2;
		System.out.println("b |= 1 = " + (b |= 1));

		// ^ 按位异或 (XOR)==> 相同的为0，不同的为1
		System.out.println("2 ^ 1 = " + (2 ^ 1));
		int c = 2;
		System.out.println("c ^= 1 = " + (c^=1));

		// 左移运算符，低位补0， num << cnt: 相当于 num * (2^cnt)
		System.out.println("2 << 1 = " + (2 << 1)); 
		int d = 2;
		System.out.println("d <<= 1 = " + (d <<= 1));

		// 右移运算符，负数时高位补1，正数高位补0， num >> cnt: 相当于 num / (2^cnt)
		System.out.println("2 >> 1 = " + (2 >> 1));
		int e = 2;
		System.out.println("e >>= 1 = " + (e >>= 1));

		// 无符号右移，空位补0， num >>> cnt : 相当于 num / (2^cnt) 
		System.out.println("4 >>> 1 = " + (4 >>> 1));
		int f = 2;
		System.out.println("f >>>= 1 = " + (f >>>= 1));

		// 输出二进制
		System.out.println("\n4 => 二进制: " + Integer.toBinaryString(0x06));
		
	}
}

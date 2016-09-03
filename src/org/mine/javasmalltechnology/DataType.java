
package org.mine.javasmalltechnology;

public class DataType {

	public static void main(String[] args) {

		/**
		 * 基本数据的类型的包装类也只是在对应的值[-128, 127]【注意：char与Character的这个区间为(-∞, 127]】这个区间才可以使用常量池，因为他们至少占用一个字节
		 */
		
		useInteger();
		System.out.println("*********************");
		useLong();
		System.out.println("*********************");
		useCharacter();
	}

	public static void useInteger() {
		Integer i1 = 59;
		int i2 = 59;
		Integer i3 = Integer.valueOf(59);
		Integer i4 = new Integer(59);
		
		System.out.println(i1 == i2); // true Integer会自动拆箱调用initValue()返回为int类型
		System.out.println(i1 == i3); // true 都指向IntegerCache[59-(-128)]对象
		System.out.println(i3 == i4); // false 引用指向的对象地址不同
		System.out.println(i2 == i4); // true 同第一行解释
	}
	
	public static void useLong() {
		Long i1 = (long) 59;
		long i2 = 59;
		Long i3 = Long.valueOf(59);
		Long i4 = new Long(59);
		
		System.out.println(i1 == i2); // true Integer会自动拆箱调用initValue()返回为int类型
		System.out.println(i1 == i3); // true 都指向LongCache[*]对象
		System.out.println(i3 == i4); // false 引用指向的对象地址不同
		System.out.println(i2 == i4); // true 同第一行解释
	}
	
	public static void useCharacter() {
		// Ĭ 300  127
		Character i1 = '';
		char i2 = '';
		Character i3 = Character.valueOf('');
		Character i4 = new Character('');
		
		System.out.println(i1 == i2); // true Integer会自动拆箱调用initValue()返回为int类型
		System.out.println(i1 == i3); // true 小于等于127时都指向IntegerCache[*]对象
		System.out.println(i3 == i4); // false 引用指向的对象地址不同
		System.out.println(i2 == i4); // true 同第一行解释
	}

}

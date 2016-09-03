
package org.mine.javasmalltechnology;

public class ClassLoader {

	public static void main(String[] args) {
		java.lang.ClassLoader classLoader = ClassLoader.class.getClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());

	}

}

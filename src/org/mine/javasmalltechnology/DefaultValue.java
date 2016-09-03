
package org.mine.javasmalltechnology;

public class DefaultValue {

	private boolean flag;
	private int a;
	private Object obj;
	
	public static void main(String[] args) {
		DefaultValue dv = new DefaultValue();
		System.out.println("boolean default value: " + dv.flag);
		System.out.println("int default value: " + dv.a);
		System.out.println("Object default value: " + dv.obj);
	}

}

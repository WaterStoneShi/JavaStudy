
package org.mine.java.entity;

import java.io.Serializable;

public class SerializableEntity implements Serializable{

	private static final long serialVersionUID = -157711689139544270L;
	private String name;
	private int age;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	/*private void writeObject(ObjectOutput out) throws IOException {

		System.out.println("writeObject");
	}

	private void readObject(ObjectInput in) throws IOException {
		System.out.println("readObject");
	}*/

	/**
	 * 反序列化时会调用此方法，若要是序列化单例时可以重写该方法 
	 */
	private Object readResolve() {
		System.out.println("readResolve");
		return this;
	}

	/**
	 * 在序列化之前调用该方法 
	 */
	private Object writeReplace(){
		System.out.println("writeReplace");
		return this;
	}
	/*
	 * 如果序列化的类中有以下方法，执行顺序如下
	 * writeReplace
	 * writeObject
	 * readObject
	 * readResolve
	 */
	@Override
	public String toString() {
		return super.toString()+" : " + this.getName() + "; " + this.getSex() + "; " + this.getAge();
	}
}

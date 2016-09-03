
package org.mine.java.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableEntity implements Externalizable{

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
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal");
		out.writeObject(this.getName());
		out.writeInt(this.getAge());
		out.writeObject(this.getSex());
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
		/**
		 * 注意：读取顺序与写入顺序一致
		 */
		
		System.out.println("readExternal");
		name = (String) in.readObject();
		age = in.readInt();
		sex = (String) in.readObject();
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
	private Object readResolve() throws IOException{
		System.out.println("readResolve");
		return this;
	}
	
	/**
	 * 在序列化之前调用该方法 
	 */
	private Object writeReplace() throws IOException{
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

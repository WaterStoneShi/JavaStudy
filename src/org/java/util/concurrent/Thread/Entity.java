
package org.java.util.concurrent.Thread;

import java.util.concurrent.Callable;

public class Entity implements Callable<Entity>{

	private String name;
	private String age;
	private String sex;
	
	public Entity(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public Entity call() throws Exception {
		String name = this.getName();
		System.out.println(name +" is statring");
		System.out.println(getName() + " ===> \n");
		if("zhangsan".equals(this.getName())){
			System.out.println("zhangsan is sleeping");
			Thread.sleep(5000);
		}
		
		this.setName(this.getName() + "is done !!!");
		System.out.println(name +" is end");
		return this;
	}
}

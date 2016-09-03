
package org.mine.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.mine.java.entity.ExternalizableEntity;
import org.mine.java.entity.SerializableEntity;

public class UseSerializable implements Serializable{

	// 如果不指定UID,如果在序列化之后修改了类，反序列化则会报错
	private static final long serialVersionUID = 6994618214677586444L;


	public static void main(String[] args) {

//		serializable();
//
//		unserializable();
		
		externalizable();
		
		unexternalizable();
	}

	public static void unserializable() {
		SerializableEntity serializableEntity = null;
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("d:/serialiable.obj"));
			serializableEntity = (SerializableEntity) inputStream.readObject();
			System.out.println("unserializable ==> "+serializableEntity);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	public static void serializable() {
		SerializableEntity serializableEntity = new SerializableEntity();
		serializableEntity.setName("xiaoqiang");
		serializableEntity.setSex("男");
		serializableEntity.setAge(22);
		System.out.println("serializable ==> "+serializableEntity);
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d:/serialiable.obj"));
			outputStream.writeObject(serializableEntity);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public static void unexternalizable() {
		
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("d:/externalizable.obj"));
			ExternalizableEntity entity = (ExternalizableEntity) inputStream.readObject();
			System.out.println("unexternalizable ==> "+entity);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	public static void externalizable() {
		ExternalizableEntity entity = new ExternalizableEntity();
		entity.setName("xiaohong");
		entity.setAge(18);
		entity.setSex("女");
		System.out.println("externalizable ==> "+entity);
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/externalizable.obj"));
			objectOutputStream.writeObject(entity);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}

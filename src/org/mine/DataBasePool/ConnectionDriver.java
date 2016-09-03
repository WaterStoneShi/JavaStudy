
package org.mine.DataBasePool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class ConnectionDriver {

	static class ConnectionHandler implements InvocationHandler{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if(method.getName().equals("commit")){
				TimeUnit.MILLISECONDS.sleep(100);
			}
			return null;
		}
	}
	
	public static final Connection createConnection(){
		return (Connection)Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
				new Class[]{Connection.class}, new ConnectionHandler());
	}
	
	public static void main(String[] args) throws SQLException {
		ConnectionDriver.createConnection().commit();
		System.out.println(ConnectionDriver.createConnection().toString());
	}
}

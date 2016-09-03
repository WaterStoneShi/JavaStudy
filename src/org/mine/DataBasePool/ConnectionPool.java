
package org.mine.DataBasePool;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {

	private LinkedList<Connection> pool = new LinkedList<Connection>();

	public ConnectionPool(int poolSize){

		if(poolSize > 0){
			for(int i = 0; i < poolSize; i++){
				pool.addLast(ConnectionDriver.createConnection());
			}
		}
	}

	public void releaseConnection(Connection conn){
		if(conn != null){
			synchronized(pool){
				pool.addLast(conn);
				pool.notifyAll();
			}
		}
	}

	public Connection fetchConnection(long mills) throws InterruptedException{

		synchronized(pool){
			if(mills <= 0){
				while(pool.isEmpty()){
					pool.wait();
				}
				return pool.removeFirst();
			}else{
				long future = System.currentTimeMillis() + mills;
				long remaining = mills;
				while(pool.isEmpty() && remaining > 0){
					pool.wait(mills);
					remaining = future - System.currentTimeMillis();
				}
				Connection result = null;
				if(!pool.isEmpty()){
					result = pool.removeFirst();
				}
				return result;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Integer i = new Integer(0);

		new Thread(new R(i)).start();

		Thread.sleep(5000);
	}

	static class R implements Runnable{

		private Integer i;
		public R(Integer i){
			this.i = i;
		}

		@Override
		public void run() {
			try {
				synchronized(i){
					i.wait(2000);
				}
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}

		}

	}
}

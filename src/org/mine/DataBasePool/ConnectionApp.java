
package org.mine.DataBasePool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionApp {

	static ConnectionPool cp = new ConnectionPool(10);
	static CountDownLatch start = new CountDownLatch(1);
	static CountDownLatch end;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		int threadSize = 40;
		
		end = new CountDownLatch(threadSize);
		
		int count = 20;
		AtomicInteger got = new AtomicInteger();
		AtomicInteger noGot = new AtomicInteger();
		for(int i = 0; i < threadSize; i++){
			new Thread(new ConnectionRunner(count, got, noGot), "connThread_"+i).start();
		}
		start.countDown();
		end.await();
		System.out.println("total invoke: " + threadSize * count);
		System.out.println("success: " + got);
		System.out.println("fail: " + noGot);
	}
	
	static class ConnectionRunner implements Runnable{

		int count = 0;
		AtomicInteger got;
		AtomicInteger noGot;
		
		public ConnectionRunner(int count, AtomicInteger got, AtomicInteger noGot) {
			super();
			this.count = count;
			this.got = got;
			this.noGot = noGot;
		}

		@Override
		public void run() {
			try {
				ConnectionApp.start.await();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
			
			while(this.count > 0){
				
				try {
					Connection conn = cp.fetchConnection(1000);
					if(conn != null){
						try {
							conn.createStatement();
							conn.commit();
						} catch (SQLException exception) {
							exception.printStackTrace();
						}finally{
							cp.releaseConnection(conn);
							got.incrementAndGet();
							System.out.println("success");
						}
						
					}else{
						System.out.println("fail");
						noGot.incrementAndGet();
					}
				} catch (InterruptedException exception) {
					noGot.incrementAndGet();
					System.out.println("catch");
					exception.printStackTrace();
				}finally{
					count--;
				}
			}
			end.countDown();
		}
	}
}

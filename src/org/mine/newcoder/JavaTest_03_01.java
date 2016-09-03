
package org.mine.newcoder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 
 * wait 方法在被唤醒之后是需要获取锁的
 * 
 */
public class JavaTest_03_01 {

	private static String PATHNAME = "d:/source.data";
	private static int THREAD_GROUPS = 5;
	private static int DATA_LEN = 2000 * THREAD_GROUPS;
	private static int GROUP_DATA = DATA_LEN / THREAD_GROUPS;


	public static void main(String[] args) {

		try {

			PrintWriter pw = new PrintWriter(new File(PATHNAME));
			Random random = new Random();
			for(int i = 0; i < DATA_LEN; i++){
				pw.print((Math.abs(random.nextInt()%100)+" "));
			}
			pw.flush();
			pw.close();


			BufferedReader br = new BufferedReader(new FileReader(new File(PATHNAME)));
			String readLine = br.readLine();
			br.close();
			String[] source = readLine.split(" ");

			int l = source.length;

			int index = 0;
			for(int i = 0; i < THREAD_GROUPS; i++){
				int[] groupData = new int[GROUP_DATA];
				for(int j = 0; j < GROUP_DATA; j++){
					groupData[j] = Integer.parseInt(source[index]);
					index++;
				}

				PrintWriter groupPw = new PrintWriter(new FileWriter(new File("d:/group_"+i+"_out.data")), true);
				ThreadGroup tg = new ThreadGroup(groupPw, groupData);
				new Thread(tg, "tgA_"+i).start();
				new Thread(tg, "tgB_"+i).start();
			}

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}

	}

	public static void main1(String[] args) {
		ThreadGroup tg = new ThreadGroup(null, null);
		new Thread(tg, "tgA_").start();
		new Thread(tg, "tgB_").start();
	}

	static class ThreadGroup implements Runnable{

		private static final Object lock = new Object();
		private PrintWriter pw;
		private int[] data;
		private static int COUNT;
		private static int TYPE_D = 0;
		private static int TYPE_S = 1;
		private int type;
		private int doubleIndex = 0;
		private int singleIndex = 0;
		private volatile boolean running;

		public ThreadGroup(PrintWriter pw, int[] groupData){
			this.pw = pw;
			this.data = groupData;
			this.type = TYPE_D;
		}

		@Override
		public void run() {
			while(print());
			synchronized(this){
				notifyAll();
			}
		}

		private synchronized boolean print() { 

			String name = Thread.currentThread().getName();

			if(TYPE_D == this.type){

				for(int i = 0; i < 10;){
					if((this.doubleIndex) >= data.length){
						if((this.singleIndex) >= data.length)
							return false;
						else
							break;
					}

					int integer = data[doubleIndex];
					if(integer % 2 == 0){
						i++;
						this.pw.print(name + " ==> " + integer + "\n");
						this.pw.flush();
						synchronized(lock){
							COUNT++;
							if(COUNT % 1000 == 0){
								System.out.println("当前完成数量:  " + COUNT);
								if(COUNT == DATA_LEN){
									System.out.println("Done");
									return false;
								}
							}
						}
					}
					doubleIndex++;
				}
			}else{

				for(int i = 0; i < 10;){
					if((this.singleIndex) >= data.length){
						if((this.doubleIndex) >= data.length)
							return false;
						else
							break;
					}

					int integer = data[singleIndex];
					if(integer % 2 != 0){
						i++;
						this.pw.print(name + " ==> " + integer + "\n");
						this.pw.flush();
						synchronized(lock){
							COUNT++;
							if(COUNT % 1000 == 0){
								System.out.println("当前完成数量:  " + COUNT);
								if(COUNT == DATA_LEN){
									System.out.println("Done");
									return false;
								}
							}
						}
					}
					singleIndex++;
				}
			}

			this.type = ~this.type;
			notifyAll();
			try {
				wait();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
			return true;
		}

	}
}

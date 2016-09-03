
package org.mine.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * PipedReader、PipedWriter、PipedInputStream、PipedOutputStream
 * 主要用于线程间传输数据，传输介质为内存
 * 
 */
public class Piped {

	public static void main(String[] args) throws IOException {
		PipedWriter pipedWriter = new PipedWriter();
		PipedReader pipedReader = new PipedReader();
//		pipedReader.connect(pipedWriter);

		pipedWriter.connect(pipedReader);

		Thread print = new Thread(new Print(pipedReader), "Thread_print");
		print.start();

		int write = 0;
		while((write = System.in.read()) != -1){
			pipedWriter.write(write);
		}

	}

	private static class Print implements Runnable{

		private PipedReader pipedReader;
		public Print(PipedReader pipedReader){
			this.pipedReader = pipedReader;
		}


		@Override
		public void run() {
			int receive = 0;
			try {
				while((receive = this.pipedReader.read()) != -1){
					System.out.print(receive);
				}
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}

	}

}

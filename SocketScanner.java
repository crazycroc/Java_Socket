package org.networks.sock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class SocketScanner {
  static int startPortRange = 0;
	static int stopPortRange = 65000;
	static int numberofthreads = 1000;

	public static void main(String[] args) throws IOException {

		InputParameters();

		// Get LocatHost
		String localhost = InetAddress.getLocalHost().getHostAddress();
		System.out.println("LocalHost is : " + localhost);

		// Create names and ranges for threads
		String[] threadsnames = new String[numberofthreads];
		int threadPie = (stopPortRange - startPortRange) / numberofthreads;
		Range[] threadRange = new Range[numberofthreads];
		RunnableThread[] threads = new RunnableThread[numberofthreads];

		int temp = startPortRange;
		// Create threads and run them
		for (int i = 0; i < numberofthreads; i++) {
			threadRange[i] = new Range(temp, temp + threadPie - 1);
			threadsnames[i] = "Thread_" + (i + 1); // threads have obtained
													// names
			threads[i] = new RunnableThread(threadsnames[i], localhost,
					threadRange[i].getStart(), threadRange[i].getEnd());
			temp += threadPie;
		}

		for (int i = 0; i < numberofthreads; i++) {
			threads[i].run();
		}

	}

	private static void InputParameters() throws IOException {
		try {
			BufferedReader isr = new BufferedReader(new InputStreamReader(
					System.in));
			System.out
					.print("Please, insert startPortRange\nstartPortRange = ");
			startPortRange = Integer.parseInt(isr.readLine());
			System.out.print("Please, insert stopPortRange\nstopPortRange = ");
			stopPortRange = Integer.parseInt(isr.readLine());
			System.out.print("Please, insert numberofthreads\nnumberofthreads = ");
			numberofthreads = Integer.parseInt(isr.readLine());
			
			if(startPortRange < 0 || stopPortRange < startPortRange || numberofthreads > stopPortRange - startPortRange)
			{
				System.out.println("Invalid Parameter : Working with defaults : 0, 65000, 2");
				startPortRange = 0; stopPortRange = 65000; numberofthreads = 2;
			}
		} catch (Exception e) {
			System.out.println("Invalid parameter");
		}

	}

}

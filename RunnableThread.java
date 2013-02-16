package org.networks.sock;
import java.net.Socket;

class RunnableThread implements Runnable {

  private Thread runner;
	private int start;
	private int end;
	//static String result = null;
	private String socketname = null;

	public RunnableThread(int startrange, int endrange) {
		start = startrange;
		end = endrange;
	}

	public RunnableThread(String threadName, String socket_nm,  int startrange, int endrange) {
		runner = new Thread(this, threadName);
		socketname = socket_nm;
		start = startrange;
		end = endrange;
		runner.start(); 
		System.out.println(runner.getName());
	}

	public RunnableThread(String threadName) {
		runner = new Thread(this, threadName); 
		System.out.println(runner.getName());
		runner.start();
	}

	public void run() {
		String thrname = Thread.currentThread().getName();
		String res = null;
		for (int i = start; i <= end; i++) {
			res = runthread(socketname, i);
			System.out.println(thrname + " : " + res);
		}

	}

	private String runthread(String socketname, int i) {
		Socket ServerSok = null;
		try {
			ServerSok = new Socket(socketname, i);

			ServerSok.close();
			return ("Port in use: ################################## " + i)
					.toString();

		} catch (Exception e) {
			// return ("Port not in use: " + i + ", EXCPTN = " +
			// e.toString()).toString();
		} finally {
			try {
				ServerSok.close();
			} catch (Exception e) {

			}

		}
		return ("Port not in use: " + i).toString();
	}

}

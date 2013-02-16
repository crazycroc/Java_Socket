package org.networks.sock;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Scanner {

  public static void main(String[] args) throws UnknownHostException {
		String localhost = InetAddress.getLocalHost().getHostAddress();
		Socket ServerSok = null;
		for (int i = 0; i < 65534; i++) {
			try {
				ServerSok = new Socket(localhost, i);
				System.out.println("Port in use: " + i);
				ServerSok.close();

			} catch (Exception e) {
				// System.out.println("Port not in use: " + i + ", EXCPTN = " +	// e.toString());
			}
			finally
			{
				try {
					ServerSok.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

}

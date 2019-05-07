package fr.imtld.time.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Service implements Runnable {
	protected Socket sock;
	public Service(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run() {
		OutputStream os;
		try {
			os = this.sock.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			String strDateTime = new Date().toString();
			pw.println(strDateTime);
			pause(1000);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void pause(long ms) {
        synchronized (this) {
                try {
                        wait(ms);
                } catch (InterruptedException e) {
                }
        }
	}

}

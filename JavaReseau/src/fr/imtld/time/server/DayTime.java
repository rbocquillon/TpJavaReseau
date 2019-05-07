package fr.imtld.time.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DayTime implements Runnable {
	protected ServerSocket sockSvr;

	public static void main(String[] args) {
		DayTime dt = new DayTime();
		dt.serve();
	}

	private void serve() {
        System.out.println("Taper entrée pour quitter");
		Thread thr = new Thread(this);
        thr.start();
        try {
			System.in.read();
			sockSvr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			sockSvr = new ServerSocket( 22222 );
			while (true) {
		        Socket sock = sockSvr.accept();
		        Service service = new Service(sock);
		        Thread thr = new Thread(service);
		        service.run();
			}
		} catch(IOException e) {
			System.err.println(e);
		}
	}	
}

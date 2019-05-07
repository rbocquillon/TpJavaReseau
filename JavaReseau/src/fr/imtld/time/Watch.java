package fr.imtld.time;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Watch {
    protected void displayLocalTime() {
    		Date date1 = new Date();
            System.out.println(date1);
    }
    
    protected void displayServerTime(String strServer) {
    	try {
    		InetAddress addr = InetAddress.getByName( strServer );
        	Socket sock = new Socket( addr, 22222 );
        	InputStream is = sock.getInputStream();
        	InputStreamReader isr = new InputStreamReader( is );
        	BufferedReader br = new BufferedReader( isr );
        	String strDateTime = br.readLine();
        	System.out.println(strDateTime);
        	sock.close();
    	} catch(UnknownHostException e){
    		System.err.println(e);
    	} catch(IOException e) {
    		System.err.println(e);
    	}
    }
    
    protected void displayServerTime(String strServer, String zoneDeTemps) {
    	try {
    		InetAddress addr = InetAddress.getByName( strServer );
        	Socket sock = new Socket( addr, 22222 );
        	InputStream is = sock.getInputStream();
        	InputStreamReader isr = new InputStreamReader( is );
        	BufferedReader br = new BufferedReader( isr );
        	String strDateTime = br.readLine();
        	System.out.println(strDateTime);
        	sock.close();
    	} catch(UnknownHostException e){
    		System.err.println(e);
    	} catch(IOException e) {
    		System.err.println(e);
    	}
    }
    
    public static void main( String args[] ) {
            Watch watch = new Watch();
            if(args.length==0)
            	watch.displayLocalTime();
            else if(args.length==1)
            	watch.displayServerTime(args[0]);
            else if(args.length==2)
            	watch.displayServerTime(args[0], args[1]);
            else
            	System.out.println("Usage : java fr.imtld.time.Watch <daytime_server>");
    }
}

import java.util.*;
import java.io.*;
import java.net.*;
import java.util.Base64;
import java.net.ServerSocket;
//import java.util.Arrays;
public class Main {
	
public static void main(String... args){
	ServerSocket ss;
	try{
		
		ss = new ServerSocket(9719);
		System.out.println("enter");
		Socket s;
		while((s=ss.accept())!=null){
			System.out.println("client connected");
			InputStream ism = s.getInputStream();
			OutputStream osm = s.getOutputStream();
			DataInputStream dis = new DataInputStream(ism);
			DataOutputStream dos = new DataOutputStream(osm);
			String msg = "Hello World!";
			dos.write( Base64.getEncoder().encode(msg.getBytes()) );
			dos.close();
			dis.close();
			ism.close();
			osm.close();
			s=null;
		}
		ss.close();
	}
	catch(Exception e){
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		System.out.println("==========");
		System.out.println(sw.toString());
		System.out.println("==========");
	}
	
	//Inet4Address sa = Inet4Address.getByName("127.0.0.1")

}
public static class ClientThread extends Thread{
	@Override 
	public void run(){
		
	}
	public ClientThread(){
		
	}
}
}

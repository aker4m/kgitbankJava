package _39_day;

import java.net.*;
import java.io.*;

public class ClassTest5 {
	public static void main(String[] args) throws IOException{
		String msg = "Hello java!";
		
		byte[] str = msg.getBytes();
		
		InetAddress ia = InetAddress.getByName("192.168.0.92");
		
		DatagramPacket dp = new DatagramPacket(str, str.length, ia, 12345);
		
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		ds.close();
		
		System.out.println("Àü¼Û ³¡ .............");
	}
}

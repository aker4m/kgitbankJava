package _40_day;

import java.net.*;
import java.io.*;

public class ClassTest1 {
	public static void main(String[] args) throws IOException{
		InetAddress ia = InetAddress.getByName("230.230.230.230");
		
		String msg = "Hello";
		DatagramPacket dp = new DatagramPacket(
				msg.getBytes(), msg.length(), ia, 12345);
		MulticastSocket ms = new MulticastSocket();
		ms.send(dp);
		ms.close();
	}
}

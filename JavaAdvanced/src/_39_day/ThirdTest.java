package _39_day;

import java.net.*;
import java.io.*;

public class ThirdTest {
	public static void main(String[] args) throws IOException{
		byte[] str = new byte[65508];
		String data = null;
		DatagramPacket dp = new DatagramPacket(str, str.length);
		
		DatagramSocket ds = new DatagramSocket(12345);
		while(true){
			ds.receive(dp);
			data = new String(dp.getData()).trim();
			if(data == "exit") break;
			byte[] str1 = data.getBytes();
			InetAddress ia = dp.getAddress();
			
			DatagramPacket dp1 = new DatagramPacket(str1, str1.length, ia, 12345);
			DatagramSocket ds1 = new DatagramSocket();
			ds1.send(dp);
		}
		
		ds.close();
		
		
	}
}

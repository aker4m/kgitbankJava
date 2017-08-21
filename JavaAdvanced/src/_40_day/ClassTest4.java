package _40_day;

import java.net.*;
import java.io.*;

public class ClassTest4 {
	public static void main(String[] args) throws IOException{
		DatagramSocket ds = new DatagramSocket(12345);
		byte[] by = new byte[65508];
		while(true){
			DatagramPacket dp = new DatagramPacket(by, by.length);
			ds.receive(dp);
			InetAddress ia = dp.getAddress();
			String msg = new String(dp.getData()).trim();
			System.out.println(ia.getHostName() + " ==> "+msg);
		}
	}
}

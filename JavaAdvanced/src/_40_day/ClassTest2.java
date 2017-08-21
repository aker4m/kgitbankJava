package _40_day;

import java.io.*;
import java.net.*;

public class ClassTest2 {
	public static void main(String[] args) throws IOException{
		InetAddress ia = InetAddress.getByName("230.230.230.230");
		MulticastSocket ms = new MulticastSocket(12345);
		ms.joinGroup(ia);
		
		while(true){
			DatagramPacket dp = new DatagramPacket(new byte[65508], 65508);
			ms.receive(dp);
			
			System.out.println("보낸이 : " + dp.getAddress());
			System.out.println("내용물 : "+new String(dp.getData()).trim());
		}
	}
}

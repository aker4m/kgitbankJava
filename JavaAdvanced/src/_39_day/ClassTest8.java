package _39_day;
import java.io.*;
import java.net.*;
public class ClassTest8 {
	public static void main(String[] args) throws IOException{
		byte str[] = new byte[65508];
		DatagramPacket dp = new DatagramPacket(str, str.length);
		DatagramSocket ds = new DatagramSocket(12345);
		
		ds.receive(dp);
		
		InetAddress ia = dp.getAddress();
		String data = new String(dp.getData()).trim();
		
		System.out.println("보낸이의 주소 : " + ia.getHostAddress());
		System.out.println("데이타 : " + data);
		
		DatagramPacket dp2 = new DatagramPacket
				(data.getBytes(), data.length(), ia , 22222);
		ds.send(dp2);
		
		ds.close();
	}
}










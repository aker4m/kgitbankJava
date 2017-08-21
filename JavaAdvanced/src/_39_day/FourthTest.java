package _39_day;

import java.util.*;
import java.net.*;
import java.io.*;

public class FourthTest {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String msg = null;
		InetAddress ia = InetAddress.getByName("192.168.0.80");
		DatagramSocket ds = new DatagramSocket(22222);
		while(true){
			System.out.print("������ �޽���:");
			msg = sc.nextLine();
			byte str[] = msg.getBytes();
			DatagramPacket dp = new DatagramPacket(str, str.length, ia, 12345);
			
			ds.send(dp);
			DatagramPacket dp2 = new DatagramPacket(new byte[65508], 65508);
			ds.receive(dp2);
			msg = new String(dp2.getData()).trim();
			if(msg.equals("exit")) break;
			System.out.println("�������� �� �޼��� : " +	msg);
		}
		ds.close();
		
	}
}

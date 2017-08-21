package _39_day;

import java.net.*;
import java.io.*;
import java.util.*;

public class FifthTest extends Thread{
	byte str[];
	DatagramPacket dp;
	DatagramPacket dp2;
	DatagramSocket ds;
	DatagramSocket ds2;
	String msg=null;
	Scanner sc = new Scanner(System.in);
	InetAddress ia;
	String data;
	
	public FifthTest() throws IOException{
		Thread th = new Thread(this);
		th.start();
		str = new byte[65508];
		
		dp = new DatagramPacket(str, str.length);
		ds = new DatagramSocket(12345);
		
		this.init();
	}
	
	public void init() throws IOException{
		while(true){
			ds.receive(dp);
			data = new String(dp.getData()).trim();
			System.out.println("데이타 : " + data);
		}
	}
	
	public void run() {
		try {
			ia = InetAddress.getByName("192.168.52.35");
			ds2 = new DatagramSocket(22222);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true){
			System.out.println("메시지 : ");
			msg = sc.nextLine();
			DatagramPacket dp2 = new DatagramPacket(msg.getBytes(), msg.length(), ia , 22222);
			try {
				
				ds2.send(dp2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		new FifthTest();
	}
}

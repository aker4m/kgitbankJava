package _40_day;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class ClassTest3 {
	public static void main(String[] args) throws IOException{
		DatagramSocket ds = new DatagramSocket();
		String msg = JOptionPane.showInputDialog(null, "전송할 메세지 : ", "입력", JOptionPane.QUESTION_MESSAGE);
		InetAddress ia = InetAddress.getByName("192.168.52.255");
		DatagramPacket dp = new DatagramPacket(
				msg.getBytes(), msg.length(), ia, 12345);
		ds.send(dp);
		ds.close();
	}
}

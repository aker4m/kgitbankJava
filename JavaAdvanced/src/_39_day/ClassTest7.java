package _39_day;
import java.io.*;
import java.net.*;
public class ClassTest7 {
	public static void main(String[] args) throws IOException{
		String msg = "Hello java";
		
		byte str[] = msg.getBytes();
		InetAddress ia = InetAddress.getByName("localhost");
		
		DatagramPacket dp = new DatagramPacket
												(str, str.length, ia, 12345);
		DatagramSocket ds = new DatagramSocket(22222);
		ds.send(dp);
		DatagramPacket dp2 = new DatagramPacket
											(new byte[65508], 65508);
		ds.receive(dp2);
		ds.close();
		
		System.out.println("서버에서 온 메세지 : " + 
								new String(dp2.getData()).trim());
	}
}







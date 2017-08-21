package _38_day;

import java.net.*;
import java.io.*;

public class ClassTest4 {
	public static void main(String[] args){
		InetAddress ia = null;
		Socket soc = null;
		String msg = "Hello Java!!";
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try{
			ia = InetAddress.getByName("192.168.52.35");
			soc = new Socket(ia, 12345);
			osw = new OutputStreamWriter(soc.getOutputStream());
			bw = new BufferedWriter(osw);
			pw = new PrintWriter(bw);
			pw.println(msg);
			pw.flush();
			
			System.out.println("클라이언트 전송 끝!");
		}catch(Exception e){}
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		try{
			isr = new InputStreamReader(soc.getInputStream());
			br = new BufferedReader(isr);
			msg = br.readLine();
			System.out.println("전송받은 내용 : "+ msg);
			soc.close();
		}catch(Exception e){}
	}
}

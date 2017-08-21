package _38_day;

import java.net.*;
import java.io.*;

public class ClassTest3 {
	public static void main(String[] args){
		ServerSocket ss = null;
		Socket soc = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try{
			ss = new ServerSocket(12345);
			System.out.println("서버 대기중...");
			soc = ss.accept();
			System.out.println("접속자 정보 : "+soc.toString());
			isr = new InputStreamReader(soc.getInputStream());
			br = new BufferedReader(isr);
			String msg = br.readLine();
			System.out.println("전송된 내용 : "+ msg);
		}catch(IOException e){}
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try{
			String msg = "Hi!";
			osw = new OutputStreamWriter(soc.getOutputStream());
			bw = new BufferedWriter(osw);
			pw = new PrintWriter(bw);
			pw.println(msg);
			pw.flush();
		}catch(IOException e){}
	}
}

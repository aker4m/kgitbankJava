package _38_day;

import java.net.*;
import java.io.*;
import java.util.*;

public class ClassTest6 extends Thread{
	//���Ͽ���
	InetAddress ia;
	Socket soc;
	
	//���� IO
	OutputStreamWriter osw;
	BufferedWriter bw;
	PrintWriter pw;
	InputStreamReader isr;
	BufferedReader br;
	
	//�Է�
	Scanner sc;
	String msg_client;
	String msg_server;
	
	public ClassTest6(){
		sc = new Scanner(System.in);
		try{
			ia = InetAddress.getByName("192.168.52.36");
			soc = new Socket(ia, 12345);
			this.start();
			osw = new OutputStreamWriter(soc.getOutputStream());
			bw = new BufferedWriter(osw);
			pw = new PrintWriter(bw);
			while(true){
				msg_client = sc.nextLine();
				pw.println(msg_client);
				pw.flush();
			}
		}catch(Exception e){}
	}
	
	public void run(){
		try{
			isr = new InputStreamReader(soc.getInputStream());
			br = new BufferedReader(isr);
			while(true){
				msg_server =br.readLine();
				System.out.println("�������� ���� ���� : " + msg_server);
				
			}
		}catch(Exception e){}
	}
	
	public static void main(String[] args){
		new ClassTest6();
	}
}

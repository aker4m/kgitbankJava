package _38_day;

import java.net.*;
import java.io.*;
import java.util.*;

public class ClassTest5 extends Thread{
	//���� IO
	InputStreamReader isr;
	BufferedReader br;
	OutputStreamWriter osw;
	BufferedWriter bw;
	PrintWriter pw;
	
	//���� ����
	ServerSocket ss;
	Socket soc;
	
	//�Է�
	Scanner sc;
	String msg_client;
	String msg_server;
	
	public ClassTest5(){
		
		try{
			ss = new ServerSocket(12345);
			System.out.println("���� �����...");
			soc = ss.accept();
			this.start();
			isr = new InputStreamReader(soc.getInputStream());
			br = new BufferedReader(isr);
			while(true){
				msg_client = br.readLine();
				System.out.println("Ŭ���̾�Ʈ���� ���� ���� : "+ msg_client);
			}
			
		}catch(Exception e){}
	}
	
	public void run(){
		sc = new Scanner(System.in);
		try{
			osw = new OutputStreamWriter(soc.getOutputStream());
			bw = new BufferedWriter(osw);
			pw = new PrintWriter(bw);
			while(true){
				msg_server = sc.next();
				pw.println(msg_server);
				pw.flush();
			}
						
		}catch(Exception e){}
		
	}
	
	public static void main(String[] args){
		new ClassTest5();
	}
}

package _39_day;

import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Echo extends Thread{
	private ArrayList<Socket> list;
	private Socket soc;
	private BufferedReader br;
	private String name;
	private PrintWriter pw;
	
	public Echo(ArrayList<Socket> list, Socket soc){
		this.list = list;
		this.soc = soc;
	}
	public void run(){
		
		try {
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			name = br.readLine();
			sendMsg(name +"님이 입장하셨습니다.");
			
			while(true){
				String msg = br.readLine();
				sendMsg(name +" : "+ msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void sendMsg(String msg){
		for(int i=0;i<list.size();i++){
			Socket sock = list.get(i);
			if(sock != soc){
				try {
					pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())));
					pw.println(msg);
					pw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}

public class SecondTest {
	public static void main(String[] args){
		ServerSocket ss = null;
		ArrayList<Socket> list = new ArrayList<Socket>();
		try{
			ss = new ServerSocket(12345);
			while(true){
				System.out.println("서버 대기중...");
				Socket soc = ss.accept();
				
				InetAddress ia = soc.getInetAddress();
				System.out.println(ia.getHostAddress()+"가 접속함");
				list.add(soc);
				new Echo(list, soc).start();
			}
		}catch(IOException e){}
		
	}
}

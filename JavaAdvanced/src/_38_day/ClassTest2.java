package _38_day;

import java.net.*;
import java.io.*;

public class ClassTest2 {
	public static void main(String[] args){
		InetAddress ia = null;
		InetAddress ias[] = null;
		
		try{
			ia = InetAddress.getByName("www.kgitbank.co.kr");
			ias = InetAddress.getAllByName("www.naver.com");
			System.out.println("IP주소 : " + ia.getHostAddress());
			System.out.println("도메인명 : "+ia.getHostName());
			for(int i=0;i<ias.length;i++){
				System.out.println(ias[i].getHostAddress());
			}
			System.out.println(InetAddress.getByName("localhost").getHostAddress());
		}catch(UnknownHostException e){
			System.out.println("없는 주소입니다.");
		}
	}
}

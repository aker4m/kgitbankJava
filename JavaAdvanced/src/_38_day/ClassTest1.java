package _38_day;

import java.net.*;
import java.io.*;

public class ClassTest1 {
	public static void main(String[] args){
		ServerSocket ss = null;
		for(int i=0;i<65535;i++){ //1023�������� ��������
			try{
				ss = new ServerSocket(i);
				ss.close();
			}catch(IOException e){
				System.err.println(i+"���� ������� ��Ʈ��ȣ�Դϴ�.");
			}
		}
	}
}

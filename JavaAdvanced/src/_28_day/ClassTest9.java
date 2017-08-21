package _28_day;

import java.text.SimpleDateFormat;
import java.util.Date;

class A09 extends Thread{
	Date date;
	SimpleDateFormat sdf;
	public A09(){
		sdf = new SimpleDateFormat("HH:mm:ss");
	}
	public void run(){
		while(true){
			date = new Date();
			System.out.println("����ð� : "+sdf.format(date));
			try{
				Thread.sleep(1000);//���罺���� ����
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

public class ClassTest9 {
	public static void main(String[] args){
		A09 ap = new A09();
		ap.setDaemon(true);//���ο� ���� ������� �Ѵ�
		ap.start();
		try{
			ap.join(5000);
			Thread.sleep(5000);//���罺���� ����
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

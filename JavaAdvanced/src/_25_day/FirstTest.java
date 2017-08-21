package _25_day;

import java.util.Scanner;

class Student2{
	public String name;
	public int kor;
	public int eng;
	public int total;
	public int rank;
	
	public Student2(String name, int kor, int eng){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.total = kor+eng;
		rank = 1;
	}
	public void disp(){
		System.out.printf("�л��� �̸�: %s, ����: %d, ����: %d �Դϴ�.\n",
				this.name, this.total, this.rank);
	}
}

public class FirstTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("�ο����� �Է��ϼ���:");
		int studentNum = sc.nextInt();
		
		Student2[] st = new Student2[studentNum];
		
		for(int i=0;i<studentNum;i++){
			System.out.println((i+1)+"��° �л��� �̸��� �Է��ϼ���:");
			String name = sc.next();
			System.out.println((i+1)+"��° �л��� ���������� �Է��ϼ���:");
			int kor = sc.nextInt();
			System.out.println((i+1)+"��° �л��� ���������� �Է��ϼ���:");
			int eng = sc.nextInt();
			st[i]= new Student2(name, kor, eng);
			System.out.println((i+1)+"��° �л��� ���� �Է��� �Ϸ��Ͽ����ϴ�.");
		}
		
		for(int i=0; i<studentNum;i++){
			for(int j=0;j<studentNum;j++){
				if(st[i].total< st[j].total)
					st[i].rank++;
			}
		}
		
		for(int i=0;i<studentNum;i++){
			st[i].disp();
		}
	}
}

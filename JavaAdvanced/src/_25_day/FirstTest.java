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
		System.out.printf("학생의 이름: %s, 총점: %d, 순위: %d 입니다.\n",
				this.name, this.total, this.rank);
	}
}

public class FirstTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("인원수를 입력하세요:");
		int studentNum = sc.nextInt();
		
		Student2[] st = new Student2[studentNum];
		
		for(int i=0;i<studentNum;i++){
			System.out.println((i+1)+"번째 학생의 이름을 입력하세요:");
			String name = sc.next();
			System.out.println((i+1)+"번째 학생의 국어점수를 입력하세요:");
			int kor = sc.nextInt();
			System.out.println((i+1)+"번째 학생의 영어점수를 입력하세요:");
			int eng = sc.nextInt();
			st[i]= new Student2(name, kor, eng);
			System.out.println((i+1)+"번째 학생의 점수 입력을 완료하였습니다.");
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

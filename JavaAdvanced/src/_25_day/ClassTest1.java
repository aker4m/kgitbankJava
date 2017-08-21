package _25_day;

import java.util.Scanner;

class SungJuk{
	private String name;
	private int kor;
	private int eng;
	private int total;
	private int rank;
	public SungJuk(String name, int kor, int eng){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		total = kor + eng;
		rank = 1;
	}
	public void setKor(int kor){
		this.kor = kor;
		setTotal();
	}
	public void setEng(int eng){
		this.eng = eng;
		setTotal();
	}
	protected void setTotal(){
		total = kor + eng;
	}
	public String getName(){
		return name;
	}
	public int getKor(){
		return kor;
	}
	public int getEng(){
		return eng;
	}
	public int getTotal(){
		return total;
	}
	public int getRank(){
		return rank;
	}
	public void clearRank(){
		rank = 1;
	}
	public void plusRank(){
		rank++;
	}
	public void disp(){
		System.out.println(name+"님의 총점은"+
					total+"점이고, 순위는 "+rank+"등 입니다.");
	}
}

public class ClassTest1 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.print("인원수를 입력 : ");
		int inwon = in.nextInt();
		
		SungJuk[] sj = new SungJuk[inwon]; //클래스 배열
		
		for(int i=0;i<sj.length; i++){
			System.out.print(i+1+"번째 이름 : ");
			String name = in.next();
			System.out.print(i+1+"번째 국어점수 : ");
			int kor = in.nextInt();
			System.out.print(i+1+"번째 국어점수 : ");
			int eng = in.nextInt();
			sj[i] = new SungJuk(name, kor, eng);
		}
		for(int i=0;i<sj.length;i++){
			sj[i].clearRank();
			for(int j=0;j<sj.length;j++){
				if(sj[i].getTotal()< sj[j].getTotal()) sj[i].plusRank();
			}
		}
		for(int i=0;i<sj.length;i++){
			sj[i].disp();
		}
	}
}

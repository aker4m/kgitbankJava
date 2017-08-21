package _25_day;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Student{
	private String name;
	private int kor;
	private int eng;
	private int total;
	private int rank;
	
	public Student(String name, int kor, int eng){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.rank = 1;
		this.total = kor+eng;
	}
	public String getName(){
		return name;
	}
	protected void setTotal(){
		total = kor + eng;
	}
	public int getTotal(){
		return total;
	}
	public void setKor(int kor){
		this.kor = kor;
		setTotal();
	}
	public void setEng(int eng){
		this.eng = eng;
		setTotal();
	}
	public void disp(){
		System.out.println(name+"님의 총점은 "+total+"이고, 순위는 "+rank+"입니다.");
	}
	public void clearRank(){
		rank=1;
	}
	public void plusRank(){
		rank++;
	}
}
class StudentPro{
	HashSet hs;
	Scanner sc;
	public StudentPro(){
		hs = new HashSet();
		sc = new Scanner(System.in);
	}
	public void insert(){
		System.out.print("이름을 입력 : ");
		String name = sc.next();
		System.out.print("국어 점수를 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력 : ");
		int eng = sc.nextInt();
		Student insert = new Student(name, kor, eng);
		hs.add(insert);
	}
	public void view(){
		Iterator it = hs.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			Student view = (Student)obj;
			rank();
			view.disp();
		}
		/*
		for(it = hs.iterator();it.hasNext();){
			Object obj = it.next();
			Student view = (Student)obj;
			view.disp();
		}
		*/
	}
	public void delete(){
		System.out.print("삭제할 이름 : ");
		String name = sc.next();
		Iterator it = hs.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			Student delete = (Student)obj;
			if(name.equals(delete.getName())){
				hs.remove(delete);
				System.out.println(name+"님을 삭제하였습니다.");
				return;
			}
		}
		System.out.println(name+"님은 저희 학생이 아닙니다.");
	}
	public void edit(){
		System.out.print("수정할 학생의 이름 : ");
		String name = sc.next();
		Iterator it = hs.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			Student edit = (Student)obj;
			if(edit.getName().equals(name)){
				System.out.print("수정할 국어 점수를 입력 : ");
				int kor = sc.nextInt();
				System.out.print("수정할 영어 점수를 입력 : ");
				int eng = sc.nextInt();
				edit.setKor(kor);
				edit.setEng(eng);
				System.out.println(name+"님의 점수를 수정하였습니다.");
				return;
			}
		}
		System.out.println(name+"님은 저희 학생이 아닙니다.");
	}
	public void exit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
	protected void rank(){
		Student[] rank = new Student[hs.size()];
		hs.toArray(rank);
		for(int i=0;i<rank.length;i++){
			rank[i].clearRank();
			for(int j=0;j<rank.length;j++){
				if(rank[i].getTotal()<rank[j].getTotal()){
					rank[i].plusRank();
				}
			}
		}
	}
}

public class ThirdTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StudentPro pro = new StudentPro();
		
		while(true){
			System.out.print("1.학생입력  2.학생출력  3.학생삭제  4.학생수정  5.종료 : ");
			int select = sc.nextInt();
			switch(select){
			case 1: pro.insert(); break;
			case 2: pro.view(); break;
			case 3: pro.delete(); break;
			case 4: pro.edit(); break;
			case 5: pro.exit(); break;
			default : 
				System.out.println("잘못입력하였습니다.");
			}
		}
	}
}

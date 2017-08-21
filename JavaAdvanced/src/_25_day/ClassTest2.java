package _25_day;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ClassTest2 {
	public static void main(String[] args){
		HashSet hs = new HashSet();
		Scanner in = new Scanner(System.in);
		
		hs.add("유재석");
		hs.add("정형돈");
		hs.add("하하");
		hs.add("노홍철");
		hs.add("박명수");
		hs.add("정준하");
		
		Iterator it = hs.iterator(); //반복자, 추출작업
		while(it.hasNext()){
			Object obj = it.next(); //업캐스팅
			String name = (String)obj;
			System.out.println(name);
		}
		/*
		System.out.print("삭제할 멤버의 이름: ");
		String name = in.next();
		if(hs.remove(name)){ //해당 객체가 있으면 삭제 후 true, 없으면 false
			System.out.println(name+"멤버를 삭제하였습니다.");
		} else {
			System.out.println(name+"은 무한도전 멤버가 아닙니다.");
		}
		*/
		/*
		System.out.print("찾으시는 멤버의 이름 : ");
		String name = in.next();
		if(hs.contains(name)){ //해당 객체를 찾는다.
			System.out.println("무한도전 멤버가 맞습니다.");
		}else {
			System.out.println("무한도전 멤버가 아닙니다.");
		}
		*/
		/*
		System.out.println("무한도전 멤버의 수 : "+hs.size());//크기 구하기
		hs.clear(); // 다 삭제하겠다.
		System.out.println("무한도전 멤버의 수 : "+hs.size());
		*/
	}
}

package _27_day;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassTest1 {
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		list.add("유재석");
		list.add("정형돈");
		list.add("하하");
		list2.add("정준하");
		/*
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		//오토 박싱
		*/
		System.out.println(list.indexOf("정형돈"));
		
		for(int i=0;i<list.size();i++){
			Object obj = list.get(i); // index로 데이타를 꺼내올 수 있다.
			String name = (String)obj;
			System.out.println(name);
		}
		list.add(1, "박명수");
		for(Iterator it = list.iterator();it.hasNext(); ){
			Object obj = it.next();
			String name = (String)obj;
			System.out.println(name);
		}
	}
}

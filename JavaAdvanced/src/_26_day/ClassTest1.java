package _26_day;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ClassTest1 {
	public static void main(String[] args){
		HashMap map = new HashMap();
		
		map.put("유재석", "개그맨");
		map.put("박명수", "개그맨");
		
		Set set = map.keySet();
		//key에 저장된 값을 set타입으로 넘겨줍니다.
		Iterator it = set.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			String job = (String)map.get(key);
			System.out.println(key+"님의 직업은 "+job+"입니다.");
		}
		
		/*
		if(map.remove("강호동")!= null){
			System.out.println("강호동님을 삭제하였습니다.");
		}else {
			System.out.println("강호동님은 저희 멤버가 아닙니다.");
		}
		*/
		/*
		if(map.containsKey("강호동")){
			System.out.println("강호동은 저희 멤버입니다.");
		}else{
			System.out.println("강호동은 저희 멤버가 아닙니다.");
		}
		*/
		/*
		Object obj = map.get("유재석");
		String job = (String)obj;
		System.out.println("유재석의 직업: "+job);
		*/
	}
}

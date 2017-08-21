package _28_day;

//문자열 분할 3가지 클래스를 모두 알아보자
import java.util.*;
public class ClassTest3 {
	public static void main(String[] args){
		String msg = "홍 길동 tt 서울 강북 tt 25 tt 010-111-1111 tt";
		Scanner in = new Scanner(msg).useDelimiter("\\s*tt\\s*");
		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println(in.next());
		in.close();
		/*
		String result[] = msg.split("tt");
		for(int i=0;i<result.length;i++){
			System.out.println(result[i].trim());
		*/
			/*
		StringTokenizer st=new StringTokenizer(msg, "tt");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken().trim());
		*/	
		
	}
}

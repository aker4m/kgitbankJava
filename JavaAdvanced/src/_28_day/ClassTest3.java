package _28_day;

//���ڿ� ���� 3���� Ŭ������ ��� �˾ƺ���
import java.util.*;
public class ClassTest3 {
	public static void main(String[] args){
		String msg = "ȫ �浿 tt ���� ���� tt 25 tt 010-111-1111 tt";
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

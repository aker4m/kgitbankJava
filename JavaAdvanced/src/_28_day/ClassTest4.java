package _28_day;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassTest4 {
	public static void main(String[] args){
		String id="11ad_";
		if(Pattern.matches("^[a-zA-Z0-9_]*$", id)){
			System.out.println("����� �Է��ϼ̽��ϴ�.");
		}else{
			System.out.println("����, ����, �����(_)�� �Է� �����մϴ�.");
		}
	/*
		Pattern pat = Pattern.compile("[a-z]+");
		Matcher mat = pat.matcher("www.java2s.com");
		
		while(mat.find())
			System.out.println("Match: " + mat.group());
	*/	
	}
}

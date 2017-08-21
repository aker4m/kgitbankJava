package _28_day;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassTest4 {
	public static void main(String[] args){
		String id="11ad_";
		if(Pattern.matches("^[a-zA-Z0-9_]*$", id)){
			System.out.println("제대로 입력하셨습니다.");
		}else{
			System.out.println("영문, 숫자, 언더바(_)만 입력 가능합니다.");
		}
	/*
		Pattern pat = Pattern.compile("[a-z]+");
		Matcher mat = pat.matcher("www.java2s.com");
		
		while(mat.find())
			System.out.println("Match: " + mat.group());
	*/	
	}
}

package _37_day;

import java.io.*;

public class ClassTest1 {
	public static void main(String[] args){
		File f1 = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day\\aaa.txt");
		File f2 = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day", "bbb.txt");
		
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File dir2 = new File("D:"+File.separator+"raonolje_bigdata"+File.separator+"workspace"+File.separator+"JavaAdvanced"+File.separator+"src"+"_37_day");
		File f3 = new File(dir, "ccc.txt");
		/*
		System.out.println("File.separator = "+File.separator);
		System.out.println("File.separatorChar = "+File.separatorChar);
		System.out.println("File.pathSeparator = "+File.pathSeparator);
		System.out.println("File.pathSeparatorChar = "+File.pathSeparatorChar);
		*/
	}
}

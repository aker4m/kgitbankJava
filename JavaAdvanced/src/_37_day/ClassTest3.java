package _37_day;

import java.io.*;

public class ClassTest3 {
	public static void main(String[] args) throws IOException{
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "aaa.txt");
		
		FileOutputStream fos = new FileOutputStream(f, true);
		//true시 append 기능이 됨, false나 없으면 rewrite
		String str = "Hello java";
		byte[] by = str.getBytes();
		fos.write(by);
		/*
		fos.write(by, 6, 4);
		*/
		/*
		for(int i=0;i<by.length;i++){
			fos.write(by[i]);
		}
		*/
		/*
		fos.write('A');
		fos.write(66);
		*/
	}
}

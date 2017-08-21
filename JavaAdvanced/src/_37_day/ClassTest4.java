package _37_day;

import java.io.*;

public class ClassTest4 {
	public static void main(String[] args) throws IOException{
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "aaa.txt");
		
		FileInputStream fis = new FileInputStream(f);
		//FileNotFoundException발생 
		while(true){
			int res = fis.read();//fis에서 한글자 읽어오기
			if(res<0) break; //1byte에서 파일의 끝은 -1을 반환한다
			//즉, EOF값이 -1이다.
			System.out.println((char)res);
		}
	}
}

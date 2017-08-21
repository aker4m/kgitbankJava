package _37_day;

import java.io.*;

public class ClassTest7 {
	public static void main(String[] args) throws IOException{
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "ccc.txt");
		
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.print("안녕하세요! ");
		pw.println("자바수업시간입니다.");
		pw.println("내일은 네트워크에 대해 배워봅시다!");
		pw.println(20);
		pw.close();
	}
}

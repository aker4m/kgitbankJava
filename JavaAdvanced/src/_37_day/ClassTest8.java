package _37_day;

import java.io.*;

public class ClassTest8 {
	public static void main(String[] args) throws IOException{
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "ccc.txt");
		
		FileReader fr = new FileReader(f);
		//InputStreamReader
		BufferedReader br = new BufferedReader(fr);
		
		while(true){
			String msg = br.readLine();
			if(msg == null) break;
			System.out.println(msg);
		}
		
		
	}
}

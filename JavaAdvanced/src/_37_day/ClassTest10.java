package _37_day;

import java.io.*;

public class ClassTest10 {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "ddd.txt");
		
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		Object obj = ois.readObject();
		A09 ap = (A09)obj;
		System.out.println("a = "+ ap.a);
		System.out.println("b = "+ ap.b);
	}
}

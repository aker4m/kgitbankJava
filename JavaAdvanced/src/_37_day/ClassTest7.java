package _37_day;

import java.io.*;

public class ClassTest7 {
	public static void main(String[] args) throws IOException{
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "ccc.txt");
		
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.print("�ȳ��ϼ���! ");
		pw.println("�ڹټ����ð��Դϴ�.");
		pw.println("������ ��Ʈ��ũ�� ���� ������ô�!");
		pw.println(20);
		pw.close();
	}
}

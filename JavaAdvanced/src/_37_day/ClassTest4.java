package _37_day;

import java.io.*;

public class ClassTest4 {
	public static void main(String[] args) throws IOException{
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "aaa.txt");
		
		FileInputStream fis = new FileInputStream(f);
		//FileNotFoundException�߻� 
		while(true){
			int res = fis.read();//fis���� �ѱ��� �о����
			if(res<0) break; //1byte���� ������ ���� -1�� ��ȯ�Ѵ�
			//��, EOF���� -1�̴�.
			System.out.println((char)res);
		}
	}
}

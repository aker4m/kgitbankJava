package _37_day;

import java.io.*;

public class ClassTest5 {
	public static void main(String[] args) throws IOException{
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "bbb.txt");
		
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeInt(10);
		dos.writeDouble(10.23);
		dos.writeUTF("�ȳ��ϼ���");
		
		//dos.flush();//�ڿ� �Է��� ���� �� ���� ���
		dos.close(); //flush()+close() // �Է��� ���� ���� ���
		
	}
}

package _37_day;

import java.io.*;

class A09 implements Serializable{
	//����ȭ�� Ŭ����
	int a = 10;
	transient int b = 20; //���� �ȵǰ� �ϴ� �ɼ�
}

public class ClassTest9 {
	public static void main(String[] args) throws IOException{
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "ddd.txt");
		
		A09 ap = new A09();
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(ap);
		oos.close();
		//����ȭ ���� �߻�
		//�޸𸮿� ���ķ� ����Ǿ� �ִ� ���� ����ȭ ������� ���尡����
		//��� �ʵ尪�� ����, �޼ҵ� ���� �ȵ�
	}
}

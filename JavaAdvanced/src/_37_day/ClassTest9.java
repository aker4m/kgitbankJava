package _37_day;

import java.io.*;

class A09 implements Serializable{
	//직렬화된 클래스
	int a = 10;
	transient int b = 20; //전송 안되게 하는 옵션
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
		//직렬화 에러 발생
		//메모리에 병렬로 저장되어 있는 것을 직렬화 시켜줘야 저장가능함
		//멤버 필드값만 저장, 메소드 저장 안됨
	}
}

package _37_day;

import java.io.*;
import javax.swing.*;

public class ClassTest2 {
	public static void main(String[] args) throws IOException, InterruptedException{
		JFileChooser jfc = new JFileChooser(".");
		int res = jfc.showSaveDialog(null);
		File file = null;
		if(res==0){
			file = jfc.getSelectedFile();
		}
		
		
		/*
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_day");
		File f = new File(dir, "aaa.txt");
		
		String list[] = dir.list();
		for(int i=0;i<list.length;i++){
			System.out.println(list[i]);
		}
		*/
		/*
		System.out.println("������ ũ�� :" +f.length());
		//������ ũ�⸦ �˷��ִ� �޼ҵ�, ������� long���·� ���´�
		System.out.println(f.getAbsolutePath());
		*/
		/*
		if(f.canWrite()){
			System.out.println("���Ͽ� ���Ⱑ �����մϴ�.");
		}else{
			System.out.println("���Ͽ� ���Ⱑ �Ұ����մϴ�.");
		}
		*/
		/*
		if(f.canRead()){
			System.out.println("������ ���� �� �ֽ��ϴ�.");
		}else{
			System.out.println("������ ���� �� �����ϴ�.");
		}
		*/
		/*
		File tmp = File.createTempFile("temp", ".kbc", dir);
		tmp.deleteOnExit();	
		*/
		/*
		if(f.createNewFile()){
			//������ ������ ����� true��, ������ ������ false��
			System.out.println("aaa.txt ������ ��������ϴ�.");
		}else{
			System.out.println("aaa.txt ������ �̹� �����մϴ�.");
		}
		*/
		Thread.sleep(5000);
	}
}

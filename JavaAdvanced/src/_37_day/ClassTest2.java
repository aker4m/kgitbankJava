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
		System.out.println("파일의 크기 :" +f.length());
		//파일의 크기를 알려주는 메소드, 결과값을 long형태로 나온다
		System.out.println(f.getAbsolutePath());
		*/
		/*
		if(f.canWrite()){
			System.out.println("파일에 쓰기가 가능합니다.");
		}else{
			System.out.println("파일에 쓰기가 불가능합니다.");
		}
		*/
		/*
		if(f.canRead()){
			System.out.println("파일을 읽을 수 있습니다.");
		}else{
			System.out.println("파일을 읽을 수 없습니다.");
		}
		*/
		/*
		File tmp = File.createTempFile("temp", ".kbc", dir);
		tmp.deleteOnExit();	
		*/
		/*
		if(f.createNewFile()){
			//파일이 없으면 만들고 true를, 파일이 있으면 false를
			System.out.println("aaa.txt 파일을 만들었습니다.");
		}else{
			System.out.println("aaa.txt 파일은 이미 존재합니다.");
		}
		*/
		Thread.sleep(5000);
	}
}

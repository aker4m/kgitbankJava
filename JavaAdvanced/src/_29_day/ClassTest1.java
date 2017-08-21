package _29_day;

import java.awt.Frame;
import java.awt.Label;

public class ClassTest1 {
	public static void main(String[] args){
		Frame fr1 = new Frame();
		Frame fr2 = new Frame("awt");
		fr1.setSize(400, 400);//컴포넌트를 화면에 표시할지 안할지 선택
		fr2.setSize(300, 300);
		fr1.setVisible(true);
		fr2.setVisible(true);
		fr1.setLocation(100, 200);
		fr2.setLocation(400, 200);
		
		Label lb = new Label("반장아 대답 좀 해!!");
		fr2.add(lb);
	}
}


//자바 GUI 프로그래밍
//awt : 운영체제의 컴포넌트를 활용
// -Frame (java.awt.*)
//swing

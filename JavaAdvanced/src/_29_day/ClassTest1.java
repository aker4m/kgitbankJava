package _29_day;

import java.awt.Frame;
import java.awt.Label;

public class ClassTest1 {
	public static void main(String[] args){
		Frame fr1 = new Frame();
		Frame fr2 = new Frame("awt");
		fr1.setSize(400, 400);//������Ʈ�� ȭ�鿡 ǥ������ ������ ����
		fr2.setSize(300, 300);
		fr1.setVisible(true);
		fr2.setVisible(true);
		fr1.setLocation(100, 200);
		fr2.setLocation(400, 200);
		
		Label lb = new Label("����� ��� �� ��!!");
		fr2.add(lb);
	}
}


//�ڹ� GUI ���α׷���
//awt : �ü���� ������Ʈ�� Ȱ��
// -Frame (java.awt.*)
//swing

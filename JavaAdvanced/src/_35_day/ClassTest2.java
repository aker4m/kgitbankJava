package _35_day;

import java.awt.*;
import java.io.File;

import javax.swing.*;

class MyFrame02 extends JFrame{
	private ImageIcon ii1 = new ImageIcon("./src/_35_day/a.gif");
	private ImageIcon ii2 = new ImageIcon("./src/_35_day/b.gif");
	private ImageIcon ii3 = new ImageIcon("./src/_35_day/c.gif");
	private ImageIcon ii4 = new ImageIcon("./src/_35_day/d.gif");
	private JToggleButton jtb1 = new JToggleButton(ii1);
	private JToggleButton jtb2 = new JToggleButton(ii2);
	private JToggleButton jtb3 = new JToggleButton("��ư3", ii3);
	private JToggleButton jtb4 = new JToggleButton("��ư4", ii4);
	
	private ButtonGroup bg = new ButtonGroup();
	
	public void init(){
		//����
		Container con = this.getContentPane();
		JFileChooser jfc = new JFileChooser(".");
		int res = jfc.showOpenDialog(this);
		if(res==0){
			File file = jfc.getSelectedFile();
			System.out.println(file);
		}
		//res�� 0�̸� ���� ���� ����, �׷��� ������ ���
		/*
		Color color = JColorChooser.showDialog(this, "������!", Color.red);
		con.setBackground(color);
		*/
		/*
		con.setLayout(new GridLayout(1, 4));
		jtb1.setRolloverIcon(ii4);
		jtb2.setSelectedIcon(ii4);
		jtb2.setToolTipText("��ư�� ������ 4�� �̹����� ���Ϳ�");
		bg.add(jtb1); con.add(jtb1);
		bg.add(jtb2); con.add(jtb2);
		jtb3.setHorizontalTextPosition(SwingConstants.CENTER);
		jtb3.setVerticalTextPosition(SwingConstants.BOTTOM);
		bg.add(jtb3); con.add(jtb3);
		bg.add(jtb4); con.add(jtb4);
		*/
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public MyFrame02(String title){
		super(title);
		this.init(); //��缳�� �Ǵ� �ʱⰪ����
		this.start(); //event����
		this.setSize(500, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){}
		String name = JOptionPane.showInputDialog(this, "�̸��� ����?", "����", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(this, name+"���� �����ϼ̽��ϴ�.", "�޽���", JOptionPane.WARNING_MESSAGE);
		/*
		int res = JOptionPane.showConfirmDialog(this, "����� ��� �Ҳ���?", "����", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		System.out.println("res="+res);
		if(res==0){
			JOptionPane.showMessageDialog(this, "�����, ����", "�޼���", JOptionPane.WARNING_MESSAGE);
		}
		//JOptionPane.showMessageDialog(this, "�����, ����� ���� ���ٲ���?", "�޼���", JOptionPane.QUESTION_MESSAGE);
		*/
		
	}
}

public class ClassTest2 {
	public static void main(String[] args){
		MyFrame02 mf = new MyFrame02("swingTest");
	}
}

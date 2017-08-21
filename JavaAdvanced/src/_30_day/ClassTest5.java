package _30_day;

import java.awt.*;
import java.awt.event.*;

class MyFrame05 extends Frame implements MouseListener{
	private Button bt = new Button("����");
	
	public void init(){
		this.setLayout(new BorderLayout());
		this.add("South", bt);
		bt.addMouseListener(this);
		//A05 ap = new A05();
		//bt.addMouseListener(ap);
		//bt.addActionListener(ap);
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(0);
			}
		}; //�͸���øŬ����
		this.addWindowListener(wa);
	}
	
	public MyFrame05(String title){
		super(title);
		
		init();
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		bt.setLabel("��ư�� Ŭ���Ͻø� ���α׷��� ����˴ϴ�.");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		bt.setLabel("����");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class A05 extends MouseAdapter{

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.exit(0);
	}
		
}
/*
class A05 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		 System.exit(0);
	}
}
*/
public class ClassTest5 {
	public static void main(String[] args){
		MyFrame05 mf = new MyFrame05("awt�ǽ�05");
	}
}

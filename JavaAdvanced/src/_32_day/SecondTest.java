package _32_day;

import java.awt.*;
import java.awt.event.*;


class MyFrameSecond extends Frame implements ActionListener{
	private Button[] bt = new Button[4];
	private String[] str = new String[]{"확대", "축소", "원본", "종료"};
	
	private BorderLayout bl = new BorderLayout();
	private Panel p = new Panel();
	private GridLayout gl = new GridLayout(4, 1);
	
	private int x=200;
	private int y=200;
	public void init(){
		this.setLayout(bl);
		this.add("East", p);
		p.setLayout(gl);
		for(int i=0;i<bt.length;i++){
			bt[i]= new Button(str[i]);
			p.add(bt[i]);
			bt[i].addActionListener(this);
		}
		
	}
	public void paint(Graphics g){
		Image img = Toolkit.getDefaultToolkit().getImage("./src/_32_day/hadoop.png");
		g.drawImage(img, 50, 50, x, y, this);
		
	}
	public MyFrameSecond(String title){
		super(title);
		
		this.init();
		this.setSize(600, 500);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==bt[0]){
			x +=30;
			y +=30;
			if(x>400)	bt[0].setEnabled(false);
			if(x>50)	bt[1].setEnabled(true);
		}else if(ae.getSource()==bt[1]){
			x -=30;
			y -=30;
			if(x<50)	bt[1].setEnabled(false);
			if(x<400)	bt[0].setEnabled(true);
		}else if(ae.getSource()==bt[2]){
			x=200;
			y=200;
			bt[0].setEnabled(true);
			bt[1].setEnabled(true);
		}else if(ae.getSource()==bt[3]){
			System.exit(0);
		}
		repaint();
	}
}

public class SecondTest {
	public static void main(String[] args){
		MyFrameSecond mfs = new MyFrameSecond("두번째 문제");
	}
}

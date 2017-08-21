package _30_day;

import java.awt.*;
import java.awt.event.*;
class MyFrame06 extends Frame implements ActionListener{
	private Button bt1 = new Button("왼쪽버튼");
	private Button bt2 = new Button("오른쪽버튼");
	private Label lb = new Label("", Label.CENTER);
	private Panel p = new Panel();
	
	public void init(){
		this.setLayout(new GridLayout(2,1));
		this.add(p);
		p.setLayout(new GridLayout(1,2));
		p.add(bt1);	bt1.addActionListener(this);
		p.add(bt2);	bt2.addActionListener(this);
		this.add(lb);
	}
	
	public MyFrame06(String title){
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
	
	public void actionPerformed(ActionEvent arg0){
		if(arg0.getSource()==bt1){
			lb.setText("왼쪽버튼을 누르셨습니다.");
		}else if(arg0.getSource()==bt2){
			lb.setText("오른쪽버튼을 누르셨습니다.");
		}
	}
}

public class ClassTest6 {
	public static void main(String[] args){
		MyFrame06 mf = new MyFrame06("awt실습06");
	}
}

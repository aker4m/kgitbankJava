package _32_day;
import java.awt.*;
import java.awt.event.*;
class MyFrame01 extends Frame implements ActionListener{
	private Button bt = new Button("확인");
	int co = 0;
	public void init(){
		this.setLayout(new BorderLayout());
		this.add("South", bt);
		bt.addActionListener(this);
	}
	public void paint(Graphics g){
		System.out.println("co = " + ++co);
		g.drawLine(50,50,100,100);
	}
	
	public MyFrame01(String title){
		super(title);
		this.init();
		super.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int xpos = (int)screen.getWidth()/2 - this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2 - this.getHeight()/2;
		super.setLocation(xpos, ypos);
		
		super.setResizable(false);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		
	}
}
public class ClassTest1 {
	public static void main(String[] args){
		MyFrame01 mf = new MyFrame01("graphics실습");
	}
}

package _32_day;
import java.awt.*;
import java.awt.event.*;
class MyFrame02 extends Frame implements ActionListener{
	
	public void init(){
		
	}
	public void paint(Graphics g){
		g.drawLine(50,50,100,100);
		g.drawRect(50,50,100,100);
		g.setColor(Color.RED);
		g.fillRect(200,50, 100,100);
		g.fillOval(50, 50, 100, 100);
		int x[] = new int[]{70, 120, 50, 10};
		int y[] = new int[]{50,170, 160,  40};
		g.setColor(Color.blue);
		g.drawPolygon(x, y, 4);
		g.setFont(new Font("", Font.BOLD, 30));
		g.drawString("반장아 소리쳐서 미안해!!", 50, 200);
		Image img = Toolkit.getDefaultToolkit().getImage("a.jpg");
		g.drawImage(img, 50, 50, 200, 200, this);
	}
	
	public MyFrame02(String title){
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
public class ClassTest2 {
	public static void main(String[] args){
		MyFrame02 mf = new MyFrame02("graphics실습");
	}
}
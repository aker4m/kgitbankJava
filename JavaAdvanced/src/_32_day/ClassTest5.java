package _32_day;
import java.awt.*;
import java.awt.event.*;
class MyButton extends Button{
	private Image img = 
			Toolkit.getDefaultToolkit().getImage("a4.jpg");
	public void paint(Graphics g){
		g.drawImage(img, 10, 10, getWidth()-20, getHeight()-20, this);
	}
	public void setImage(Image img){
		this.img = img;
	}
}
class MyFrame05 extends Frame implements ActionListener{
	private MyButton bt = new MyButton();
	private Label lb = new Label("Æë±Ï");
	int co = 0;
	public void init(){
		this.setLayout(new GridLayout(2,1));
		this.add(bt); bt.addActionListener(this);
		this.add(lb);
	}
	public void paint(Graphics g){

	}
	
	public MyFrame05(String title){
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
		if (co==4) co = 0;
		co++;
		Image img = Toolkit.getDefaultToolkit().getImage("a"+co+".jpg");
		bt.setImage(img);
		bt.repaint();
		
		
	}
}
public class ClassTest5 {
	public static void main(String[] args){
		MyFrame05 mf = new MyFrame05("graphics½Ç½À");
	}
}
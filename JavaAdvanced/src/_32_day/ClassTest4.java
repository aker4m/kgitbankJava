package _32_day;
import java.awt.*;
import java.awt.event.*;
class MyImage extends Canvas{
	private Image img = null;
	public void setImage(Image img){
		this.img = img;
	}
	public void paint(Graphics g){
		g.drawImage(img, 10, 10, getWidth()-20, getHeight()-20, this);
	}
}
class MyFrame04 extends Frame implements ActionListener{
	private Button bt1 = new Button("a1");
	private Button bt2 = new Button("a2");
	private Button bt3 = new Button("a3");
	private Button bt4 = new Button("a4");
	private MyImage img = new MyImage();
	
	private Panel p = new Panel();

	public void init(){
		this.setLayout(new BorderLayout());
		this.add("North", p);
		this.add("Center", img);
		p.setLayout(new GridLayout(1,4));
		p.add(bt1);bt1.addActionListener(this);
		p.add(bt2);bt2.addActionListener(this);
		p.add(bt3);bt3.addActionListener(this);
		p.add(bt4);bt4.addActionListener(this);
	}
	
	public MyFrame04(String title){
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
		Image image;
		if (arg0.getSource()==bt1){
			image = Toolkit.getDefaultToolkit().getImage("a1.jpg");
		}else if (arg0.getSource()==bt2){
			image = Toolkit.getDefaultToolkit().getImage("a2.jpg");
		}else if (arg0.getSource()==bt3){
			image = Toolkit.getDefaultToolkit().getImage("a3.jpg");
		}else{
			image = Toolkit.getDefaultToolkit().getImage("a4.jpg");
		}
		img.setImage(image);
		img.repaint();
	}
}
public class ClassTest4{
	public static void main(String[] args){
		MyFrame04 mf = new MyFrame04("graphics½Ç½À");
	}
}
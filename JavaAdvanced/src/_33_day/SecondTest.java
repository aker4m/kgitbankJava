package _33_day;

import java.awt.*;
import java.awt.event.*;

class MyImage extends Canvas{
	private Image img = null;
	public void setImage(Image img){
		this.img = img;
	}
	public void paint(Graphics g){
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}

class MyFrameSecond extends Frame implements ActionListener{
	private Button[] bt = new Button[4];
	private String[] str = new String[]{"트와이스", "여자친구", "러블리즈", "블랙핑크"};
	private Panel p = new Panel();
	private Panel img_p = new Panel();
	private Font f = new Font("", Font.BOLD, 20);
	private MyImage img = new MyImage();
	
	public void init(){
		this.setLayout(new BorderLayout());
		this.add("North", p);
		p.setLayout(new GridLayout(1, 4));
		for(int i=0;i<bt.length;i++){
			bt[i]=new Button(str[i]);
			p.add(bt[i]);
			bt[i].addActionListener(this);
		}
		this.add("Center", img);
		
	}
	public void paint(Graphics g){
				
	}
	public MyFrameSecond(String title){
		super(title);
		
		this.init();
		this.setSize(600, 600);
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
		Image image = null;
		if(ae.getSource()==bt[0]){
			image = Toolkit.getDefaultToolkit().getImage("./src/_33_day/twice.jpg");
		}else if(ae.getSource()==bt[1]){
			image = Toolkit.getDefaultToolkit().getImage("./src/_33_day/girlfriend.jpg");
		}else if(ae.getSource()==bt[2]){
			image = Toolkit.getDefaultToolkit().getImage("./src/_33_day/lovelyz.jpg");
		}else if(ae.getSource()==bt[3]){
			image = Toolkit.getDefaultToolkit().getImage("./src/_33_day/blackpink.jpg");
		}
		img.setImage(image);
		img.repaint();
	}
}
public class SecondTest {
	public static void main(String[] args){
		MyFrameSecond frame = new MyFrameSecond("두번째 문제");
	}
}

package _31_day;

import java.awt.*;
import java.awt.event.*;

class LianButton extends Button{
	private Image img = null;
	public void paint(Graphics g){
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	public void setImage(Image img){
		this.img = img;
	}
}

class MyFrameThird extends Frame implements ActionListener, Runnable{
	private LianButton[] mole_bt = new LianButton[9];
	private Label time_lb = new Label("시간");
	private Label time_lb2 = new Label("10초");
	private Label point_lb = new Label("점수");
	private Label point_lb2 = new Label();
	private Button start_bt = new Button("시작");
	private Button end_bt = new Button("종료");
	
	private BorderLayout main_bl = new BorderLayout();
	private Panel mole_p = new Panel();
	private GridLayout mole_gl = new GridLayout(3, 3);
	private Panel info_p = new Panel();
	private GridLayout info_gl = new GridLayout(6, 1);
	
	private int time;
	private int num;
	private int point;
	public void init(){
		this.setLayout(main_bl);
		this.add("Center", mole_p);
		mole_p.setLayout(mole_gl);
		for(int i=0;i<mole_bt.length;i++){
			mole_p.add(mole_bt[i]=new LianButton());
			mole_bt[i].setEnabled(false);
			mole_bt[i].addActionListener(this);
		}
		this.add("East", info_p);
		info_p.setLayout(info_gl);
		info_p.add(time_lb);
		info_p.add(time_lb2);
		info_p.add(point_lb);
		info_p.add(point_lb2);
		info_p.add(start_bt);
		info_p.add(end_bt);
		start_bt.addActionListener(this);
		end_bt.addActionListener(this);
		
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}
	
	public void play(){
		num = (int)(Math.random()*9)+0;
		Image img = Toolkit.getDefaultToolkit().getImage("./src/_31_day/lian.png");
		mole_bt[num].setImage(img);
		mole_bt[num].repaint();
	}
	
	public MyFrameThird(String title){
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Image img=null;
		if(e.getSource()==start_bt){
			point=0;
			for(int i=0;i<mole_bt.length;i++){
				mole_bt[i].setEnabled(true);
				mole_bt[i].setImage(img);
				mole_bt[i].repaint();
			}
			point_lb2.setText(String.valueOf(point));
			Thread th = new Thread(this);
			th.start();
			
			play();
			start_bt.setEnabled(false);
		}
		if(e.getSource()==mole_bt[num]){
			mole_bt[num].setImage(img);
			point+=10;
			point_lb2.setText(String.valueOf(point));
			mole_bt[num].repaint();
			play();
						
		}
		if(e.getSource()==end_bt){
			System.exit(0);
		}
	}
	
	@Override
	public void run() {
		time=10;
		while(time>0){
			try{
				Thread.sleep(1000);//현재스레드 재우기
			}catch(Exception e){}
			time--;
			time_lb2.setText(""+time+"초");
		}
		for(int i=0;i<mole_bt.length;i++){
			mole_bt[i].setEnabled(false);
			mole_bt[i].setLabel("");
		}
		start_bt.setEnabled(true);
	}
}

public class ThirdTest {
	public static void main(String[] args){
		MyFrameThird mft = new MyFrameThird("세번째 문제");
	}
}

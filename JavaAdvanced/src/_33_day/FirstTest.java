package _33_day;

import java.awt.*;
import java.awt.event.*;

class MyFrameFirst extends Frame implements ActionListener{
	private Label lb = new Label();
	private Button[] bt = new Button[6];
	private String[] str = new String[]{"주먹", "가위", "보", "전적", "다시", "종료"};
	private Panel p = new Panel();
	private Font f = new Font("", Font.BOLD, 30);
	private Image img = Toolkit.getDefaultToolkit().getImage("./src/_33_day/fastrcp.gif");; 
	private int computer;
	private int human;
	private int win=0, same=0, lose=0;
	
	public void init(){
		this.setLayout(new BorderLayout());
		this.add("North", lb);
		this.add("East", p);
		p.setLayout(new GridLayout(6, 1));
		for(int i=0;i<bt.length;i++){
			bt[i]= new Button(str[i]);
			p.add(bt[i]);
			bt[i].addActionListener(this);
		}
		lb.setText("메시지 : 주먹, 가위 보를 누르세요!");
		lb.setAlignment(Label.CENTER);
		lb.setFont(f);
	}
	
	public void paint(Graphics g){
		
		g.drawImage(img, 50, 100, 400, 400, this);
	}
	
	public MyFrameFirst(String title){
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
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}
	
	
	public void play(){
		computer = (int)(Math.random()*3);
		
		if(computer == 0){
			img = Toolkit.getDefaultToolkit().getImage("./src/_33_day/r.jpg");
			if(human==0) {
				same++;
				lb.setText("비겼습니다.");
			}
			if(human==1) {
				win++;
				lb.setText("당신이 이겼습니다.");
			}
			if(human==2) {
				lose++;
				lb.setText("당신이 졌습니다.");
			}
		}else if(computer ==1){
			img = Toolkit.getDefaultToolkit().getImage("./src/_33_day/p.jpg");
			if(human==0) {
				lose++;
				lb.setText("당신이 졌습니다.");
			}
			if(human==1) {
				same++;
				lb.setText("비겼습니다.");
			}
			if(human==2) {
				win++;
				lb.setText("당신이 이겼습니다.");
			}
		}else if(computer ==2){
			img = Toolkit.getDefaultToolkit().getImage("./src/_33_day/s.jpg");
			if(human==0) {
				win++;
				lb.setText("당신이 이겼습니다.");
			}
			if(human==1) {
				lose++;
				lb.setText("당신이 졌습니다.");
			}
			if(human==2) {
				same++;
				lb.setText("비겼습니다.");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==bt[0]){
			human=0;
			play();
		}else if(ae.getSource()==bt[1]){
			human=1;
			play();
		}else if(ae.getSource()==bt[2]){
			human=2;
			play();
		}else if(ae.getSource()==bt[3]){
			lb.setText("승 : "+win+" 무 : "+lose+" 패: "+lose);
		}else if(ae.getSource()==bt[4]){
			img = Toolkit.getDefaultToolkit().getImage("./src/_33_day/fastrcp.gif");
			repaint();
		}else if(ae.getSource()==bt[5]){
			System.exit(0);
		}
		
	}
}

public class FirstTest {
	public static void main(String[] args){
		MyFrameFirst frame = new MyFrameFirst("가위바위보 게임");
	}
}

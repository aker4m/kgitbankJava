package _31_day;
import java.awt.*;
import java.awt.event.*;
class MyFrame02 extends Frame implements ActionListener, Runnable{
	private Button bt[] = new Button[9];
	private Label time_lb = new Label("시간 : 10초");
	private Label score_lb = new Label("점수 : 0점");
	private Button start_bt = new Button("시작");
	int time, score=0;
	int select;
	private Panel p = new Panel();
	private Panel p2 = new Panel();
	
	public void init(){
		this.setLayout(new BorderLayout());
		this.add("Center", p);
		p.setLayout(new GridLayout(3,3));
		for(int i=0; i<bt.length; ++i){
			bt[i] = new Button("");
			bt[i].setEnabled(false);
			p.add(bt[i]);
			bt[i].addActionListener(this);
		}
		this.add("East", p2);
		p2.setLayout(new GridLayout(3,1));
		p2.add(time_lb);
		p2.add(score_lb);
		p2.add(start_bt);
		start_bt.addActionListener(this);
	}
	public MyFrame02(String title){
		super(title);
		this.init();
		//Thread th = new Thread(this);
		//th.start();
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
		if (arg0.getSource()==start_bt){
			Thread th = new Thread(this);
			th.start();
			start_bt.setEnabled(false);
			for(int i=0; i<bt.length; ++i){
				bt[i].setEnabled(true);
			}
			score = 0;
			gameStart();
		}else {
			for(int i=0; i<bt.length; ++i){
				if (arg0.getSource() == bt[i]){
					if (i==select) score++;
				}
			}
			score_lb.setText("점수 : " + score+"점");
			gameStart();
			
		}
	}
	public void gameStart(){
		bt[select].setLabel("");
		select = (int)(Math.random()*9);
		bt[select].setLabel("두더지");
	}
	@Override
	public void run() {
		time = 10;
		while(time>0){
			
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
			time--;
			time_lb.setText("시간 : " + time +"초");
		}
		start_bt.setEnabled(true);
		for(int i=0; i<bt.length; ++i){
			bt[i].setEnabled(false);
		}
	}
}
public class ClassTest2 {
	public static void main(String[] args){
		MyFrame02 mf = new MyFrame02("awt실습");
	}
}
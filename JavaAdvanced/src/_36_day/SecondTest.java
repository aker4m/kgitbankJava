package _36_day;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Horse extends Canvas implements Runnable{
	private Image ho_run, ho_stop, ho_cur;
	private int num;
	private int xpos = 5;
	public static int rank = 1;
	
	public Horse(Image ho_run, Image ho_stop, int num){
		this.ho_run= ho_run;
		this.ho_stop = ho_stop;
		this.num = num;
		this.ho_cur = ho_stop;
	}
	public void paint(Graphics g){
		Dimension di = this.getSize();
		g.drawImage(ho_cur, xpos, 10, 50, (int)(di.getHeight()*0.9), this);
		g.drawLine(5,  (int)(di.getHeight()-di.getHeight()*0.1), (int)(di.getWidth()-5), (int)(di.getHeight() - di.getHeight() * 0.1));
	}
	public void run(){
		ho_cur = ho_run;
		Dimension di = this.getSize();
		for(int i=5;i<=di.getWidth()-25;i+=((Math.random()*3)+2)){
			xpos = i;
			this.repaint();
			try{
				Thread.sleep((int)(Math.random()*300)+100);
			}catch(InterruptedException e){}
		}
		ho_cur = ho_stop;
		this.repaint();
		MyFrameSecond.jta.append(rank++ +"��, �� ��ȣ = "+num+"\n");
	}
}

class MyFrameSecond extends JFrame implements ActionListener{
	private JTextField jtf = new JTextField();
	private JButton[] jbt = new JButton[3];
	private String[] str = new String[]{"����", "����", "�ʱ�ȭ"};
	private JLabel jlb = new JLabel("���� �� : ", JLabel.RIGHT);
	private JPanel jp = new JPanel();
	public static JTextArea jta = new JTextArea(5, 20);
	private Image img;
	private Container con;
	private JPanel center_jp = new JPanel();
	
	private int horseNumber;
	private Horse[] ho;
	
	public void init(){
		//����
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", jp);
		jp.setLayout(new GridLayout(1, 5));
		jp.add(jlb);
		jp.add(jtf);
		for(int i=0;i<jbt.length;i++){
			jbt[i] = new JButton(str[i]);
			jp.add(jbt[i]);
		}
		con.add("South", jta);
		
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i=0;i<jbt.length;i++){
			jbt[i].addActionListener(this);
		}
	}
		
	public MyFrameSecond(String title){
		super(title);
		this.init(); //��缳�� �Ǵ� �ʱⰪ����
		this.start(); //event����
		this.setSize(600, 500);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == jtf || ae.getSource()==jbt[0]){
			String c = jtf.getText();
			if(c == null || c.trim().length() == 0) return;
			int num = Integer.parseInt(c.trim());			
			Image aa = Toolkit.getDefaultToolkit().getImage("./src/_36_day/ho_run.gif");
			Image bb = Toolkit.getDefaultToolkit().getImage("./src/_36_day/ho_stop.gif");
			
			con.remove(center_jp);//���� JPanel ���� ����
			
			center_jp = new JPanel();
			center_jp.setLayout(new GridLayout(num, 1));
			
			ho = new Horse[num];
			for(int i = 0; i < num; ++i) {
				ho[i] = new Horse(aa, bb, i + 1);
				center_jp.add(ho[i]);				
			}
			
			con.add("Center", center_jp);
			con.validate();
		}
		if(ae.getSource()==jbt[1]){
			for(int i=0;i<ho.length;i++){
				new Thread(ho[i]).start();//������ �ٰ� �Ѵ�
			}
		}
		if(ae.getSource()==jbt[2]){
			jta.setText("");
			jtf.setText("");			
			con.remove(center_jp);
			center_jp = new JPanel();
			con.add("Center", center_jp);
			con.validate();
			Horse.rank = 1;
			jtf.requestFocus();//��Ŀ���� ���� ���� �ִ� ������ �̵�
		}
	}
	
}

public class SecondTest {
	public static void main(String[] args){
		MyFrameSecond frame = new MyFrameSecond("�渶����");
	}
}

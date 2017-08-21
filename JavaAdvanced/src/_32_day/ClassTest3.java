package _32_day;
import java.awt.*;
import java.awt.event.*;
class MyFrame_03 extends Frame implements ActionListener{
	private Button bt1 = new Button("�ָ�");
	private Button bt2 = new Button("����");
	private Button bt3 = new Button("��");
	private Button bt4 = new Button("����");
	private Button bt5 = new Button("�ٽ�");
	private Button bt6 = new Button("����");
	
	private BorderLayout bl = new BorderLayout();
	private Label msg = new Label("�޼��� : �ָ�,����,���� ��������!!");
	private Panel p = new Panel();
	private GridLayout gl = new GridLayout(6,1,5,5);
	
	private int result[] = new int[3];//result[0] = ��, result[1] = ��, result[2] = ��
	
	Image img = Toolkit.getDefaultToolkit().getImage("fastrcp.gif");

	public void init(){
		this.setLayout(bl);
		this.add("North", msg);
		this.add("East", p);
		p.setLayout(gl);
		p.add(bt1);
		p.add(bt2);
		p.add(bt3);
		p.add(bt4);
		p.add(bt5);
		p.add(bt6);
	}
	
	public void paint(Graphics g){
		g.drawImage(img, 50, 80, 300, 250, this);
	}
	
	public void start(){
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
	}
	
	public MyFrame_03(String title){
		super(title);
		this.init();
		this.start();
		super.setSize(500,400);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)(screen.getWidth()/2 - super.getWidth()/2);
		int ypos = (int)(screen.getHeight()/2 - super.getHeight()/2);
		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bt1){
			process(1);
		}else if (e.getSource()==bt2){
			process(2);
		}else if (e.getSource()==bt3){
			process(3);
		}else if (e.getSource()==bt4){
			msg.setText("�� : " + result[0] + ", �� : " + result[1] + ", �� : " + result[2]);
		}else if (e.getSource()==bt5){
			img = Toolkit.getDefaultToolkit().getImage("fastrcp.gif");
			repaint();
		}else if (e.getSource()==bt6){
			System.exit(0);
		}
	}
	public void process(int res){
		int comsu = (int)(Math.random()*3 + 1);
		switch(comsu){
		case 1 : 	img=Toolkit.getDefaultToolkit().getImage("r.jpg");
						if (res==1) {
							result[1]++;
							msg.setText("�����ϴ�.");
						}else if (res==2){
							result[2]++;
							msg.setText("����� �����ϴ�.");
						}else {
							result[0]++;
							msg.setText("����� �̰���ϴ�.");
						}
						break;
		case 2 : 	img=Toolkit.getDefaultToolkit().getImage("c.jpg");
						if (res==2) {
							result[1]++;
							msg.setText("�����ϴ�.");
						}else if (res==3){
							result[2]++;
							msg.setText("����� �����ϴ�.");
						}else {
							result[0]++;
							msg.setText("����� �̰���ϴ�.");
						}
						break;
		case 3 : 	img=Toolkit.getDefaultToolkit().getImage("p.jpg");
						if (res==3) {
							result[1]++;
							msg.setText("�����ϴ�.");
						}else if (res==1){
							result[2]++;
							msg.setText("����� �����ϴ�.");
						}else {
							result[0]++;
							msg.setText("����� �̰���ϴ�.");
						}
						break;
		}
		repaint();
	}
}
public class ClassTest3 {
	public static void main(String[] args) {
		MyFrame_03 mf = new MyFrame_03("����õ��");
	}
}
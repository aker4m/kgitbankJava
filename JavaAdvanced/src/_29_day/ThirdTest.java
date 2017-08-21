package _29_day;

import java.awt.*;
import java.awt.event.*;

class ThirdFrame extends Frame implements ActionListener{
	private MenuBar mb = new MenuBar();
	private Menu view = new Menu("����");
	private Menu edit = new Menu("����");
	private Menu help = new Menu("����");
	
	private Menu log = new Menu("���");
	
	private MenuItem normal = new MenuItem("�Ϲݿ�");
	private MenuItem advanced = new MenuItem("���п�");
	private MenuItem basic = new MenuItem("�⺻");
	
	private MenuItem copy = new MenuItem("����");
	private MenuItem paste = new MenuItem("�ٿ��ֱ�");
	
	private MenuItem logCopy = new MenuItem("��Ϻ���");
	private MenuItem logEdit = new MenuItem("����");
	private MenuItem logDelete = new MenuItem("��ϻ���");
	
	private MenuItem version = new MenuItem("��������");
	
	private TextField tf = new TextField();
	private Button[] bt = new Button[16];
	private String[] str1 = new String[]{"+", "-", "*"};
	private String[] str2 = new String[]{"0", "=", "%", "/"};
	
	private BorderLayout bl = new BorderLayout();
	private Panel p = new Panel();
	private GridLayout gl = new GridLayout(4,4);
	
	public void init(){
		this.setLayout(bl);
		this.add("North", tf);
		this.add("Center", p);
		p.setLayout(gl);
		int j=0;
		for(int i=0;i<bt.length;i++){
			if(i<4) bt[i]=new Button(String.valueOf(i+7));
			else if(i<8) bt[i]=new Button(String.valueOf(i));
			else bt[i]=new Button(String.valueOf(i-7));
			if(i%4==3 && i<12) bt[i]=new Button(str1[j++]);
			if(i>=12) bt[i]=new Button(str2[i-12]);
			p.add(bt[i]);
		}
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}
	
	public void menuInit(){
		this.setMenuBar(mb);
		mb.add(view);
		mb.add(edit);
		mb.add(help);
		view.add(normal);
		view.add(advanced);
		view.addSeparator();
		view.add(basic);
		
		edit.add(copy);
		edit.add(paste);
		edit.addSeparator();
		edit.add(log);
		log.add(logCopy);
		log.add(logEdit);
		log.add(logDelete);
		
		help.add(version);
	}
	
	public void init2(){
		for(int i=0;i<bt.length;i++){
			bt[i].addActionListener(this);
		}
	}
	
	public ThirdFrame(String title){
		super(title);
		
		init();
		init2();
		menuInit();
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0){
		for(int i=0;i<bt.length;i++){
			if(arg0.getSource()==bt[i]){
				if(i<4) tf.setText(tf.getText()+String.valueOf(i+7));
				else if(i<8) tf.setText(tf.getText()+String.valueOf(i));
				else tf.setText(tf.getText()+String.valueOf(i-7));
				if(i%4==3 && i<12){
					int j=(int)i/4;
					tf.setText(tf.getText()+str1[j]);
				}
				if(i>=12) tf.setText(tf.getText()+str2[i-12]);
			}
		}
	}
	
}

public class ThirdTest {
	public static void main(String[] args){
		ThirdFrame tf = new ThirdFrame("����° ����");
	}
}

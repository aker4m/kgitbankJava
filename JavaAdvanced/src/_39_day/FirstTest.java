package _39_day;

import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyFrameFirst extends JFrame implements ActionListener, Runnable{
	//������Ʈ��
	private JLabel jlb = new JLabel();
	private JTextArea jta = new JTextArea();
	private JTextField jtf = new JTextField();
	private JButton jbt = new JButton("����");
	private JPanel north_jp = new JPanel();
	private JPanel south_jp = new JPanel();
	
	//���� ����
	private ServerSocket ss;
	private Socket soc;
	
	//���� IO
	private PrintWriter pw;
	private BufferedReader br;
	private String msg_server;
	private String msg_client;
	
	public void init(){
		//������ ����
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", north_jp);
		north_jp.setLayout(new BorderLayout());
		north_jp.add("Center", jlb);
		jlb.setBackground(Color.yellow);
		con.add("Center", jta);
		con.add("South", south_jp);
		south_jp.setLayout(new BorderLayout());
		south_jp.add("Center", jtf);
		south_jp.add("East", jbt);
		
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbt.addActionListener(this);
	}
	public void serverSetting(){
		try {
			ss = new ServerSocket(12345);
			jlb.setText("���� �����...");
			soc = ss.accept();
			jlb.setText("Ŭ���̾�Ʈ�� ����");
			Thread th = new Thread(this);
			th.start();
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MyFrameFirst(String title){
		super(title);
		this.init(); //��缳�� �Ǵ� �ʱⰪ����
		this.start(); //event����
		
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		this.serverSetting();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jbt){
			msg_server = jtf.getText();
			pw.println(msg_server);
			pw.flush();
			String msg = jta.getText();
			msg += "\n"+msg_server;
			jta.setText(msg);
			jtf.setText("");
		}
	}
	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			while(true){
				msg_client = br.readLine();
				String msg = jta.getText();
				msg += "\n"+msg_client;
				jta.setText(msg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
public class FirstTest {
	public static void main(String[] args){
		MyFrameFirst frame = new MyFrameFirst("ä�� ���α׷�!");
	}
}

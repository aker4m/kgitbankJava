package _39_day;

import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyFrameFirst extends JFrame implements ActionListener, Runnable{
	//컴포넌트들
	private JLabel jlb = new JLabel();
	private JTextArea jta = new JTextArea();
	private JTextField jtf = new JTextField();
	private JButton jbt = new JButton("전송");
	private JPanel north_jp = new JPanel();
	private JPanel south_jp = new JPanel();
	
	//서버 소켓
	private ServerSocket ss;
	private Socket soc;
	
	//파일 IO
	private PrintWriter pw;
	private BufferedReader br;
	private String msg_server;
	private String msg_client;
	
	public void init(){
		//디자인 설정
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
			jlb.setText("서버 대기중...");
			soc = ss.accept();
			jlb.setText("클라이언트와 연결");
			Thread th = new Thread(this);
			th.start();
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MyFrameFirst(String title){
		super(title);
		this.init(); //모양설정 또는 초기값설정
		this.start(); //event설정
		
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
		MyFrameFirst frame = new MyFrameFirst("채팅 프로그램!");
	}
}

package _40_day;

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class MyFrameFirst extends JFrame implements ActionListener, Runnable{
	private TextArea ta = new TextArea();
	private JLabel jlb = new JLabel("메시지: ", JLabel.RIGHT);
	private JTextField jtf = new JTextField();
	private JButton jbt = new JButton("전송");
	private JPanel jp = new JPanel();
	
	private InetAddress ia;
	private DatagramPacket dp;
	private DatagramPacket dp1;
	private MulticastSocket ms;
	private MulticastSocket ms1;
	
	private Scanner sc;
	
	public void init(){
		//설정
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		ta.setFont(new Font("", Font.BOLD, 15));
		con.add("Center", ta);
		con.add("South", jp);
		jp.setLayout(new BorderLayout());
		jp.add("West", jlb);
		jp.add("Center", jtf);
		jp.add("East", jbt);
		
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbt.addActionListener(this);
	}
		
	public MyFrameFirst(String title) throws IOException{
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
		
		ia = InetAddress.getByName("230.230.230.230");
		ms = new MulticastSocket();
		Thread th = new Thread(this);
		th.start();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbt){
			String msg = jtf.getText();
			dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ia, 12345);
			try {
				ms.send(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//jta.append(jtf.getText()+"\n");
			jtf.setText("");
		}
	}
	@Override
	public void run() {
		try {
			ms = new MulticastSocket(12345);
			ms.joinGroup(ia);
			
			while(true){
				DatagramPacket dp1 = new DatagramPacket(new byte[65508], 65508);
				ms.receive(dp1);
				ta.append(dp1.getAddress()+" : ");
				ta.append(new String(dp1.getData()).trim()+"\n");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class FirstTest {
	public static void main(String[] args) throws IOException{
		MyFrameFirst frame = new MyFrameFirst("멀티캐스트 문제");
	}
}

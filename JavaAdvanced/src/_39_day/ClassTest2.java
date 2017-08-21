package _39_day;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
class MyFrame02 extends JFrame implements Runnable, ActionListener{
	private TextArea ta = new TextArea();
	private JLabel lb = new JLabel("메세지 : ", JLabel.RIGHT);
	private JTextField jtf = new JTextField();
	private JButton jbt = new JButton("전송");
	private JPanel jp = new JPanel();
	
	private InetAddress ia;
	private Socket soc;
	private PrintWriter pw;
	private BufferedReader in;
	
	public void init(){
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		ta.setFont(new Font("", Font.PLAIN, 15));
		ta.setEditable(false);
		con.add("Center", ta);
		con.add("South", jp);
		jp.setLayout(new BorderLayout());
		jp.add("West", lb);
		jp.add("Center", jtf);
		jp.add("East", jbt);
	}
	public void start(){
		jbt.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public MyFrame02(String title){
		super(title);
		this.init();
		this.start();
		super.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)(screen.getWidth()/2 - super.getWidth()/2);
		int y = (int)(screen.getHeight()/2 - super.getHeight()/2);
		super.setLocation(x, y);
		super.setResizable(false);
		super.setVisible(true);
		try{
			ia = InetAddress.getByName("localhost");
			soc = new Socket(ia, 20000);
			ta.setText("서버 접속 성공!!\n");
			pw = new PrintWriter(soc.getOutputStream(), true);
		}catch(IOException e){}
		Thread th = new Thread(this);
		th.start();
	}
	public void run(){
		try{
			in = new BufferedReader
				(new InputStreamReader(soc.getInputStream()));
			String clMsg = "";
			while(true){
				clMsg = in.readLine();
				ta.append("server : " + clMsg+"\n");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jbt){
			pw.println(jtf.getText());
			pw.flush();
			ta.append("client : " + jtf.getText()+"\n");
			jtf.setText("");
		}
	}
}

public class ClassTest2 {
	public static void main(String[] args){
		MyFrame02 mf = new MyFrame02("채팅클라이언트");
	}
}
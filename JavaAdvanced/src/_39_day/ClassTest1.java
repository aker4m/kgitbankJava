package _39_day;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
class MyFrame01 extends JFrame implements Runnable, ActionListener{
	private TextArea ta = new TextArea();
	private JLabel lb = new JLabel("메세지 : ", JLabel.RIGHT);
	private JTextField jtf = new JTextField();
	private JButton jbt = new JButton("전송");
	private JPanel jp = new JPanel();
	
	private ServerSocket ss;
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
	public MyFrame01(String title){
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
			ss = new ServerSocket(20000);
			soc = ss.accept();
			ta.setText("클라이언트 접속 성공!!\n");
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
				ta.append("client : " + clMsg+"\n");
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
			ta.append("server : " + jtf.getText()+"\n");
			jtf.setText("");
		}
	}
}

public class ClassTest1 {
	public static void main(String[] args){
		MyFrame01 mf = new MyFrame01("채팅서버");
	}
}
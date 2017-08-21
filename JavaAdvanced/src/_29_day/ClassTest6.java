package _29_day;

import java.awt.*;
import java.awt.event.*;
class MyFrame6 extends Frame implements ActionListener{

	private TextField tf = new TextField();
	private Button bt[] = new Button[16];
	private String str[] = new String[]{"7","8","9","+","4","5","6","-","1","2","3","*","0","=","%","/"};
	
	private BorderLayout bl = new BorderLayout();
	private Panel p = new Panel();
	private GridLayout gl = new GridLayout(4,4,5,5);
	
	private int firstSu=0;
	private int SecondSu=0;
	private char op='\0';
	private char op2='\0';
	private int result=0;
	public void init(){
		this.setLayout(bl);
		tf.setFont(new Font("", Font.BOLD, 30));
		this.add("North", tf);
		this.add("Center", p);
		p.setLayout(gl);
		for(int i=0; i<bt.length; ++i){
			bt[i] = new Button(str[i]);
			p.add(bt[i]);
			bt[i].addActionListener(this);
		}
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}
	public MyFrame6(String title){
		super(title);
		this.init();
		super.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int xpos = (int)screen.getWidth()/2 - this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2 - this.getHeight()/2;
		super.setLocation(xpos, ypos);
		
		super.setResizable(false);
		super.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt[3] ||e.getSource()==bt[7] || e.getSource()==bt[11] 
			|| e.getSource()==bt[14] || e.getSource()==bt[15]){
			op = e.getActionCommand().charAt(0);
			op2 = op;
			firstSu = Integer.parseInt(tf.getText());
			
			switch(op2){
			case '+': result = firstSu + SecondSu; break;
			case '-': result = firstSu - SecondSu; break;
			case '*': result = firstSu * SecondSu; break;
			case '/': result = firstSu / SecondSu; break;
			case '%': result = firstSu % SecondSu; break;
			}
			tf.setText(String.valueOf(result));
		}	
		else if(e.getSource()==bt[13]){
				SecondSu = Integer.parseInt(tf.getText());
				switch(op2){
				case '+': result = firstSu + SecondSu; break;
				case '-': result = firstSu - SecondSu; break;
				case '*': result = firstSu * SecondSu; break;
				case '/': result = firstSu / SecondSu; break;
				case '%': result = firstSu % SecondSu; break;
				}
				tf.setText(String.valueOf(result));
			}
				
		 else{
			for(int i=0; i<bt.length; ++i){
				if (e.getSource()==bt[i]){
					if(op !='\0'){
						firstSu = Integer.parseInt(tf.getText());
						tf.setText("");
						op='\0';
					}
					tf.setText(tf.getText() + bt[i].getLabel());
					
				}
			}
		}
	}
}
public class ClassTest6 {
	public static void main(String[] args){
		MyFrame6 mf = new MyFrame6("°è»ê±â");
	}
}

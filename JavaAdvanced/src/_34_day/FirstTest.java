package _34_day;

import java.awt.*;
import java.awt.event.*;

class MyFrameFirst extends Frame implements MouseListener, Runnable, ActionListener{
	private Button[][] bt = new Button[9][9];
	private boolean[][] check = new boolean[9][9];
	
	private Label time_lb = new Label("시간:");
	private Label bomb_lb = new Label("찾은 지뢰 개수:");
	private Label time_info = new Label("0초");
	private Label bomb_info = new Label();
	private Panel center_p = new Panel();
	private Panel south_p = new Panel();
	private MenuBar mb = new MenuBar();
	private Menu game = new Menu("게임");
	private Menu help = new Menu("도움말");
	private MenuItem newGame = new MenuItem("새게임");
	private MenuItem exitGame = new MenuItem("종료");
	private MenuItem helpGame = new MenuItem("지뢰찾기정보");
	
	private int time;
	
	public void init(){
		this.setLayout(new BorderLayout());
		this.add("Center", center_p);
		center_p.setLayout(new GridLayout(9, 9));
		for(int i=0;i<bt.length;i++){
			for(int j=0;j<bt[i].length;j++){
				bt[i][j]=new Button();
				center_p.add(bt[i][j]);
				bt[i][j].addMouseListener(this);
			}
		}
		this.add("South", south_p);
		south_p.setLayout(new GridLayout(1, 4));
		south_p.add(time_lb);
		south_p.add(time_info);
		south_p.add(bomb_lb);
		south_p.add(bomb_info);
		this.setMenuBar(mb);
		mb.add(game);
		mb.add(help);
		game.add(newGame);
		game.addSeparator();
		game.add(exitGame);
		help.add(helpGame);
		newGame.addActionListener(this);
		exitGame.addActionListener(this);
		helpGame.addActionListener(this);
	}
	
	private int arr[][] = new int[9][9];
	
	public void restart(){
		bombNumber=0;
		for(int i=0;i<bt.length;i++){
			for(int j=0;j<bt[i].length;j++){
				arr[i][j]=0;
				bt[i][j].setEnabled(true);
				bt[i][j].setLabel("");
				check[i][j]=false;
			}
		}
	}
	
	public void start(){
		Thread th = new Thread(this);
		th.start();
		for(int i=0;i<10; ++i){
			int x = ((int)(Math.random()*9));
			int y = ((int)(Math.random()*9));
			if(arr[x][y]!=0) i--;
			else arr[x][y]=9;
		}
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]==9) bomb(i, j);
			}
		}
		/*
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]==9){
					bt[i][j].setLabel("폭탄");
				}else if(arr[i][j]!=9){
					bt[i][j].setLabel(String.valueOf(arr[i][j]));
				}
			}
		}
		*/
		
	}
	
	public void bomb(int a, int b){
		for(int i=a-1;i<=a+1;i++){
			for(int j=b-1;j<=b+1;j++){
				try{
					if(arr[i][j]!=9) arr[i][j]++;
				}catch(Exception e){}
			}
		}
	}
	
	public void empty(int a, int b){
		bt[a][b].setLabel("0");
		for(int i=a-1;i<=a+1;i++){
			for(int j=b-1;j<=b+1;j++){
				try{
					if(check[i][j]) continue;
					check[i][j]=true;
					if(arr[i][j]==0){
						bt[i][j].setLabel(String.valueOf(arr[i][j]));
						empty(i, j);
					}
					else{
						bt[i][j].setLabel(String.valueOf(arr[i][j]));
					}
				}catch(Exception e){}
			}
		}
	}
	
	public MyFrameFirst(String title){
		super(title);
		
		this.init();
		this.start();
		this.helpGame();
		this.setSize(400, 400);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
		
	}

	@Override
	public void run() {
		time=0;
		while(time<1000){
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
			time++;
			time_info.setText(time+"초");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	private int bombNumber=0;
	@Override
	public void mouseReleased(MouseEvent me) {
		for(int i=0;i<bt.length;i++){
			for(int j=0;j<bt[i].length;j++){
				if(me.getButton()==1 && me.getSource()==bt[i][j]){
					if(arr[i][j]==0) {
						check[i][j]=true;
						empty(i, j);
					}
					else if(arr[i][j]==9) {
						bt[i][j].setLabel("폭탄");
						stopGame();
					}
					else bt[i][j].setLabel(String.valueOf(arr[i][j]));
					bt[i][j].setEnabled(false);
				}
				if(me.getButton()==3 && me.getSource()==bt[i][j]){
					bt[i][j].setLabel("B");
					bombNumber++;
					bomb_info.setText(String.valueOf(bombNumber));
				}
			}
		}
	}
	
	public void stopGame(){
		for(int i=0;i<bt.length;i++){
			for(int j=0;j<bt.length;j++){
				bt[i][j].setEnabled(false);
				if(arr[i][j]==9) bt[i][j].setLabel("폭탄");
				
			}
		}
	}
	
	private Dialog dlg = new Dialog(this, "버전");
	private Label version = new Label("버전 : 1.00", Label.CENTER);
	private Button confirm = new Button("확인");
	private Panel p = new Panel();
	public void helpGame(){
		Dimension position = Toolkit.getDefaultToolkit().getScreenSize();
		dlg.setSize(300, 150);
		int xpos= (int)(position.getWidth()/2-dlg.getWidth()/2);
		int ypos= (int)(position.getHeight()/2-dlg.getHeight()/2);
		dlg.setLocation(xpos, ypos);
		dlg.setLayout(new GridLayout(2, 1));
		dlg.add(version);
		dlg.add(p);
		p.setLayout(new BorderLayout());
		p.add("Center", confirm);
		dlg.setVisible(false);
		confirm.addActionListener(this);
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dlg.setVisible(false);
			}
		};
		dlg.addWindowListener(wa);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exitGame){
			System.exit(0);
		}
		if(ae.getSource()==newGame){
			this.restart();
			this.start();
		}
		if(ae.getSource()==helpGame){
			dlg.setVisible(true);
		}
		if(ae.getSource()==confirm){
			dlg.setVisible(false);
		}
	}
}

public class FirstTest {
	public static void main(String[] args){
		MyFrameFirst frame = new MyFrameFirst("지뢰찾기");
	}
}



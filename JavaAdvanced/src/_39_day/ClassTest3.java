package _39_day;
import java.net.*;
import java.io.*;
import java.util.*;
public class ClassTest3{
	private ServerSocket ss;
	private Socket soc;
	private PrintWriter pw;
	private BufferedReader br;
	private Hashtable<String, Socket>ht; //Hashmap이 아닌 테이블을 사용한 이유 : 동기화 지원
	
	public ClassTest3() throws Exception {
		ss = new ServerSocket(20000);
		ht = new Hashtable<String, Socket>();
		while(true){
			soc = ss.accept();
			ChatClient cc = new ChatClient(soc);
			cc.start();
		}
	}
	public void sendMessage(Socket soc, String name, String msge)
																		throws Exception{
		if (ht.size() != 0){
			Enumeration<String> enu = ht.keys(); //해시테이블의 이터레이터
			while(enu.hasMoreElements()){
				String n = enu.nextElement();
				Socket s = ht.get(n);
				pw = new PrintWriter(s.getOutputStream(), true);
				pw.print("["+msge+"]님 입장" + "\n");
				pw.flush();
			}
		}
		ht.put(msge, soc);
	}
	public void sendMessage(String name, String msge) throws Exception{
		Enumeration<String> enu = ht.keys();
		while(enu.hasMoreElements()){
			String n = enu.nextElement();
			//if (n.equals(name)) continue;
			Socket s = ht.get(n);
			pw = new PrintWriter(new BufferedWriter
							(new OutputStreamWriter(s.getOutputStream())));
			pw.print(name +" : " + msge + "\n");
			pw.flush();
		}
	}
	class ChatClient extends Thread{
		Socket soc;
		ChatClient(Socket soc){
			this.soc = soc;
		}
		public void run(){
			while(true){
				try{
					br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					String msg = br.readLine();
					System.out.println(msg);
					if (msg == null) break;
					if (msg.charAt(0) == '@'){
						sendMessage(soc, "@", msg.substring(1));
					}else {
						Scanner sc = new Scanner(msg).useDelimiter("\\s*:\\s*");
						String name = sc.next();
						String msge = sc.next();
						sendMessage(name, msge);
						sc.close();
					}
				}catch(Exception e){}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		new ClassTest3();
	}
}
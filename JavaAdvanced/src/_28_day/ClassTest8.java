package _28_day;
class A08 extends Thread{
	public void run(){
		System.out.println("A08Ŭ���� ����!!!");
		System.out.println("A08.currentThread="+Thread.currentThread());
	}
}
/*
class B08 extends Object implements Runnable{
	public void run(){
		System.out.println("B08Ŭ���� ����!!!");
	}
}
*/
public class ClassTest8 {
	public static void main(String[] args){
		System.out.println("���ν���!!!");
		System.out.println("main.currentThread = "+Thread.currentThread());
		A08 ap = new A08();
		//B08 bp = new B08();
		ap.setName("�����!");
		ap.setPriority(10);
		ap.start(); //�ٸ������� �������� run�޼ҵ带 ����
		/*
		Thread th = new Thread(bp);
		th.start();
		*/
		/*
		for(int i=1;i<=100;i++){
			System.out.print(i+"\t");
			if(i%10==0)
				System.out.println();
		}
		*/
		System.out.println("���� ��!!");
	}
}

package _37_member3;

import java.io.Serializable;

public class Member implements Serializable{
	private String name;
	private String tel;
	public Member(String name, String tel){
		this.name = name;
		this.tel = tel;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getName(){
		return name;
	}
	public String getTel(){
		return tel;
	}
	public void disp(){
		System.out.println(name+"님의 전화번호는 " + tel + "입니다.");
	}
}

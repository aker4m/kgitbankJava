package mall;

import java.util.*;

public class CartBean {
	Hashtable<String, Cart> ht = null;
	public CartBean(){
		ht = new Hashtable<String, Cart>();
	}
	
	public boolean addCart(String select, String pnum, String qty){
		if(ht.containsKey(pnum)){
			Cart cart = ht.get(pnum);
			cart.setQty(cart.getQty()+Integer.parseInt(qty));
		}else{
			ht.put(pnum, new Cart(select, Integer.parseInt(qty)));
		}
		return true;
	}
	public Hashtable<String, Cart> listCart(){
		return ht;
	}
	
	public void editCart(String pnum, String qty){
		Cart cart = ht.get(pnum);
		cart.setQty(Integer.parseInt(qty));
		if(Integer.parseInt(qty)<1) deleteCart(pnum);
	}
	public void deleteCart(String pnum){
		ht.remove(pnum);
	}
	public void allDeleteCart(){
		ht.clear();
	}
}

package ruandao.io;

import java.io.Serializable;
import java.util.HashMap;

public class Book implements Serializable {
	private String name;
	private int amount;
	private int count;
	
	private HashMap<String,Borrow> borrows;
	
	public HashMap<String, Borrow> getBorrows(){
		if( this.borrows == null ){
			this.borrows = new HashMap<String, Borrow>();
		}
		return this.borrows;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public Book(){
		// NO CODE
	}

	public Book(String name){
		this(name,10);
	}
	
	public Book( String name, int amount){
		this.name = name;
		this.amount = amount;
		this.count = 0;
	}
	
	public String toString(){
		String str = "《" + this.name + "》一共有" +  (this.amount + this.getBorrows().size()) + "本，";
		str += "已经借了 " + this.count + "人次，"; 
		str += this.amount == 0 ? "已经全部借出了。" : "还剩下" + this.amount + "本可借。";
		if( this.getBorrows().size() ==0 ){
			str += "该书目前一本都没有借出去。";
			return str;
		}
		str += "现在借出去" + this.getBorrows().size() + "本（";
		for( String person : this.getBorrows().keySet() ){
			str += person + ",";
		}
		str = str.substring(0, str.length()-1) + ")";
		return str;
	}

}

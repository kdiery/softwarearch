package MVC.edu.hm.kdiery.datastore.writable;

public class Kunstwerk {
	
	private String title;
	private int initialPrice;
	private boolean auctioned = false;
	private String buyer = null;
	private int soldPrice = 0;
	
	public Kunstwerk(String title, int initialPrice) {
		this.title = title;
		this.initialPrice = initialPrice;
	}

}

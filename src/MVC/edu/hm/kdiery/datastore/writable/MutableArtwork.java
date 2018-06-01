package MVC.edu.hm.kdiery.datastore.writable;

public abstract class MutableArtwork {
	
	public Kunstwerk make(String title, int initialPrice) {
		return new Kunstwerk(title, initialPrice);
	}

}

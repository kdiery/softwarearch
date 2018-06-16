import edu.hm.kdiery.mvc.datastore.writable.MutableArtwork;
import edu.hm.kdiery.mvc.logic.Auctioneer;
import edu.hm.kdiery.mvc.logic.ConcreteAuctioneer;
import edu.hm.kdiery.mvc.control.ConsoleController;
import edu.hm.kdiery.mvc.control.Controller;import edu.hm.kdiery.mvc.datastore.writable.*;

public class Anwendung_Main {

	public static void main(String... strings) {

		MutableArtwork kunst = MutableArtwork.make("Mona Lisa", 30000);
		MutableArtwork kunst2 = MutableArtwork.make("Der Schrei", 35000);
		MutableOfferings offers = MutableOfferings.make(kunst, kunst2);
		Auctioneer duc = (ConcreteAuctioneer) Auctioneer.make(offers);
		duc.run();
		Controller kaka = Controller.make("Console", duc);
		kaka.start();
		}

}

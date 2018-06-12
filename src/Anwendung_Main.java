import java.io.PrintWriter;
import java.util.Observable;
import java.util.stream.Stream;

import edu.hm.kdiery.mvc.datastore.writable.MutableArtwork;

import edu.hm.kdiery.mvc.datastore.readonly.Offerings;
import edu.hm.kdiery.mvc.view.Viewer;
import edu.hm.kdiery.mvc.datastore.writable.*;
import edu.hm.kdiery.mvc.datastore.readonly.*;
import edu.hm.kdiery.mvc.view.*;

public class Anwendung_Main {

    public static void main(String... strings) {

        MutableArtwork kunst = MutableArtwork.make("Mona Lisa", 30000);
        MutableArtwork kunst2 = MutableArtwork.make("Der Schrei", 35000);
        MutableOfferings offers = MutableOfferings.make(kunst, kunst2);
//    	Viewer duc = Viewer.make("spectator", offers, new PrintWriter(System.out));
    	final Viewer viewer = Viewer.make("logger", offers);
        offers.setBidder("Duc");
        offers.notifyObservers();
        offers.setBid(2);
        offers.notifyObservers();

    }

}

import java.io.PrintWriter;
import java.util.stream.Stream;

import edu.hm.kdiery.mvc.datastore.readonly.Offerings;
import edu.hm.kdiery.mvc.datastore.writable.AllOffers;
import edu.hm.kdiery.mvc.datastore.writable.Kunstwerk;
import edu.hm.kdiery.mvc.view.Viewer;
import edu.hm.kdiery.mvc.datastore.writable.*;
import edu.hm.kdiery.mvc.datastore.readonly.*;
import edu.hm.kdiery.mvc.view.*;

public class Anwendung_Main {

    public static void main(String... strings) {
        /*Kunstwerk[] artworksMutable = {new Kunstwerk("Mona Lisa", 2000)};
        AllOffers offers = new AllOffers(Stream.of(artworksMutable));
        ArrayList<Artwork> arts = new ArrayList<>();
        for (int i = 0; i < artworksMutable.length; i++) {
            arts.add(artworksMutable[i]);
        }
        Viewer User1 = Viewer.make("logger", offers);
        Viewer User2 = Viewer.make("spectator", offers, new PrintWriter(System.out));*/

        Kunstwerk[] monalisa = {new Kunstwerk("Mona List", 2000)};
        Offerings offerings = new AllOffers(Stream.of(monalisa));
        Viewer user = Viewer.make("spectator", offerings, new PrintWriter(System.out));
        ((AllOffers) offerings).setStepsRemaining(4);
    }

}

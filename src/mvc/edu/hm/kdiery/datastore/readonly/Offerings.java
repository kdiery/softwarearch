package mvc.edu.hm.kdiery.datastore.readonly;

import java.util.Observable;
import java.util.stream.Stream;

import mvc.edu.hm.kdiery.datastore.writable.MutableArtwork;

public abstract class Offerings extends Observable {

    public abstract Object getBidder();

    public abstract int getBid();

    public abstract Stream<MutableArtwork> getArtworks();

    public abstract int getStepsRemaining();
}

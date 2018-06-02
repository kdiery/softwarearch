package mvc.edu.hm.kdiery.datastore.writable;

import mvc.edu.hm.kdiery.datastore.readonly.Artwork;

public abstract class MutableArtwork extends Artwork {

    MutableArtwork make(String title, int initialPrice) {
        return new Kunstwerk(title, initialPrice);
    }

}

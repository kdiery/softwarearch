package mvc.edu.hm.kdiery.datastore.writable;

import mvc.edu.hm.kdiery.datastore.readonly.Artwork;

/**
 * abstract class for MutableArtwork.
 */
public abstract class MutableArtwork extends Artwork {

    /**
     * returns an instant of a Artwork.
     * @param title of artwork
     * @param initialPrice initial price
     * @return Kunstwerk
     */
    MutableArtwork make(String title, int initialPrice) {
        return new Kunstwerk(title, initialPrice);
    }

}

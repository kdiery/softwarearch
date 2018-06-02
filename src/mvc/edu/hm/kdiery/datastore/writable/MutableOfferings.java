package mvc.edu.hm.kdiery.datastore.writable;

import java.util.stream.Stream;

import mvc.edu.hm.kdiery.datastore.readonly.Offerings;

/**
 * abstract class for MutableOfferings.
 */
public abstract class MutableOfferings extends Offerings {

    /**
     * returns instant of Offerings.
     * @param artworks artworks in auction
     * @return AllOffers
     */
    MutableOfferings make(MutableArtwork... artworks) {
        return new AllOffers(Stream.of(artworks));
    }

}

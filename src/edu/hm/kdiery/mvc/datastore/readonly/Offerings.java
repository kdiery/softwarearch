package edu.hm.kdiery.mvc.datastore.readonly;

import java.util.Observable;
import java.util.stream.Stream;


/**
 * abstract class for offerings.
 */
public abstract class Offerings extends Observable {

    /**
     * returns object of bidder.
     * @return bidder
     */
    public abstract Object getBidder();

    /**
     * returns bid.
     * @return bid
     */
    public abstract int getBid();

    /**
     * return stream of artworks.
     * @return stream of artworks
     */
    public abstract Stream<? extends Artwork> getArtworks();

    /**
     * returns remaining steps.
     * @return remaining steps
     */
    public abstract int getStepsRemaining();
}

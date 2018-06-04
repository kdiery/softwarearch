package edu.hm.kdiery.mvc.datastore.writable;

import java.util.stream.Stream;

import edu.hm.kdiery.mvc.datastore.readonly.Offerings;

/**
 * abstract class for MutableOfferings.
 */
public abstract class MutableOfferings extends Offerings {

    /**
     * returns instant of Offerings.
     * @param artworks artworks in auction
     * @return AllOffers
     */
    public static MutableOfferings make(MutableArtwork... artworks) {
        return new AllOffers(Stream.of(artworks));
    }

    /**
     * sets remaining steps.
     * @param stepsReamining to be set
     * @throws IllegalArgumentException if not valid
     */
     public abstract void setStepsRemaining(int stepsReamining) throws IllegalArgumentException;

    /**
     * set bidder and bid.
     * @param bid to be set
     * @throws IllegalArgumentException if not valid value
     */
    public abstract void setBid(int bid) throws IllegalArgumentException;

    /**
     * set name of bidder.
     * @param bidder to be set
     */
    public abstract void setBidder(String bidder);



}

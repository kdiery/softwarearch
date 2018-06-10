package edu.hm.kdiery.mvc.datastore.writable;

import java.util.List;
import java.util.stream.Stream;


/**
 * concrecte class for all artworks.
 */
 class AllOffers extends MutableOfferings {

    /**
     * stream of artworks.
     */
    private final List<MutableArtwork> kunstwerke;

    /**
     * remaining steps of auction.
     */
    private int stepsRemaining = 5;

    /**
     * name of last bidder.
     */
    private String bidder;

    /**
     * current bid.
     */
    private int bid;

    /**
     * constructor for AllOffers.
     *
     * @param list all artwork in auction
     */
     /* default */AllOffers(final List<MutableArtwork> list) {
        this.kunstwerke = list;
        list.forEach(art -> art.setOfferings(this));
        this.bidder = null;
        this.bid = 0;
    }

    @Override
    public Stream<MutableArtwork> getArtworks() {
         return kunstwerke.stream();
    }

    @Override
    public int getStepsRemaining() {
        return stepsRemaining;
    }


    @Override
    public String getBidder() {
        return bidder;
    }
    
    /**
     * setChanged to signal the Observer.
     */
    public void changeData() {
    	setChanged();
    }

    @Override
    public int getBid() {
        return bid;
    }

    /**
     * sets bid only if param not negative.
     *
     * @param bid to be set
     * @throws IllegalArgumentException if param negative
     */
    @Override
    public void setBid(int bid) throws IllegalArgumentException {
        if (bid >= 0) {
            setChanged();
            this.bid = bid;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void setBidder(String bidder) {
        setChanged();
        this.bidder = bidder;
    }

    /**
     * sets remaining steps.
     *
     * @param stepsRemaining to be set.
     * @throws IllegalArgumentException if param negative
     */
    @Override
    public void setStepsRemaining(int stepsRemaining) throws IllegalArgumentException {
        if (stepsRemaining >= 0) {
            setChanged();
            this.stepsRemaining = stepsRemaining;
        } else {
            throw new IllegalArgumentException();
        }
    }

}

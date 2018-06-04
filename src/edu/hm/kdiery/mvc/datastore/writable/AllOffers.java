package edu.hm.kdiery.mvc.datastore.writable;

import java.util.stream.Stream;


/**
 * concrecte class for all artworks.
 */
 class AllOffers extends MutableOfferings {

    /**
     * stream of artworks.
     */
    private final Stream<MutableArtwork> artworks;

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
     * @param stream all artwork in auction
     */
     AllOffers(Stream<MutableArtwork> stream) {
        this.artworks = stream;
        this.bidder = null;
        this.bid = 0;
    }

    @Override
    public Stream<MutableArtwork> getArtworks() {
        return artworks;
    }

    @Override
    public int getStepsRemaining() {
        return stepsRemaining;
    }


    @Override
    public String getBidder() {
        return bidder;
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
        if (bid > 0) {
            setChanged();
            this.bid = bid;
            notifyObservers();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void setBidder(String bidder) {
        setChanged();
        this.bidder = bidder;
        notifyObservers();
    }

    /**
     * sets remaining steps.
     *
     * @param stepsRemaining to be set.
     * @throws IllegalArgumentException if param negative
     */
    @Override
    public void setStepsRemaining(int stepsRemaining) throws IllegalArgumentException {
        if (stepsRemaining > 0) {
            setChanged();
            this.stepsRemaining = stepsRemaining;
            notifyObservers();
        } else {
            throw new IllegalArgumentException();
        }
    }


}

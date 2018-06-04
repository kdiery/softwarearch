package mvc.edu.hm.kdiery.datastore.writable;

import java.util.stream.Stream;


/**
 * concrecte class for all artworks.
 */
public class AllOffers extends MutableOfferings {

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
    public AllOffers(Stream<MutableArtwork> stream) {
        this.artworks = stream;
        this.bidder = null;
        this.bid = 0;
    }

    public Stream<MutableArtwork> getArtworks() {
        return artworks;
    }

    public int getStepsRemaining() {
        return stepsRemaining;
    }



    public String getBidder() {
        return bidder;
    }

    public int getBid() {
        return bid;
    }

    /**
     * sets bid only if param not negative.
     *
     * @param parambidder of this bid
     * @param parambid    to be set
     * @throws IllegalArgumentException if param negative
     */
    void setBid(String parambidder, int parambid) throws IllegalArgumentException {
        if (bid > 0) {
            setChanged();
            this.bidder = parambidder;
            this.bid = parambid;
            notifyObservers();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * sets remaining steps
     *
     * @param stepsRemaining to be set.
     * @throws IllegalArgumentException if param negative
     */
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

package mvc.edu.hm.kdiery.datastore.writable;

import java.util.stream.Stream;

/**
 * concrecte class for all artworks.
 */
public class AllOffers {

    /**
     * stream of artworks.
     */
    private final Stream<Kunstwerk> artworks;

    /**
     * remaining steps of auction.
     */
    private int stepsRemaining;

    /**
     * name of last bidder.
     */
    private String bidder;

    /**
     * current bid.
     */
    private int bid;

    /**
     *  constructor for AllOffers.
     * @param artworks all artwork in auction
     * @param stepsRemaining remaining steps in auction
     */
    public AllOffers(Stream<Kunstwerk> artworks, int stepsRemaining) {
        this.artworks = artworks;
        this.stepsRemaining = stepsRemaining;
        this.bidder = null;
        this.bid = 0;
    }

    public Stream<Kunstwerk> getArtworks() {
        return artworks;
    }

    public int getStepsRemaining() {
        return stepsRemaining;
    }

    /**
     * set steps remaining if param non negative.
     * @param stepsRemaining
     * @throws IllegalArgumentException
     */
    public void setStepsRemaining(int stepsRemaining) throws IllegalArgumentException {
        if (stepsRemaining > 0) {
            this.stepsRemaining = stepsRemaining;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getBidder() {
        return bidder;
    }

    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    public int getBid() {
        return bid;
    }

    /**
     * sets bid only if param not negative.
     * @param bid to be set
     * @throws IllegalArgumentException if param negative
     */
    public void setBid(int bid) throws IllegalArgumentException {
        if (bid > 0) {
            this.bid = bid;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

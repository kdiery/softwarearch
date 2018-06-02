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
     * @param stream         all artwork in auction
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

    /**
     * set steps remaining if param non negative.
     *
     * @param stepsRemaining
     * @throws IllegalArgumentException
     */
    public void setStepsRemaining(int stepsRemaining) throws IllegalArgumentException {
        if (stepsRemaining > 0) {
            setChanged();
            this.stepsRemaining = stepsRemaining;
        } else {
            throw new IllegalArgumentException();
        }
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
     * @param bid    to be set.
     * @param bidder bidder of this bid.
     * @throws IllegalArgumentException if param negative.
     */
    public void setBid(String bidder, int bid) throws IllegalArgumentException {
        if (bid > 0) {
            setChanged();
            this.bidder = bidder;
            this.bid = bid;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

package edu.hm.kdiery.mvc.logic;

import edu.hm.kdiery.mvc.datastore.readonly.Artwork;
import edu.hm.kdiery.mvc.datastore.writable.MutableArtwork;
import edu.hm.kdiery.mvc.datastore.writable.MutableOfferings;

/**
 * Concrete class of auctioneer.
 */
public class ConcreteAuctioneer implements Auctioneer {

    /**
     * constant for 5.
     */
    private static final int FIVE = 5;

    /**
     * offerings of auction.
     */
    private final MutableOfferings offerings;

    /**
     * boolean if a new bid is incoming.
     */
    private boolean newBid = false;

    /**
     * Ctor of ConcreteAuctioneer.
     *
     * @param offerings of auction
     */
    public ConcreteAuctioneer(final MutableOfferings offerings) {
        this.offerings = offerings;
        System.setProperty("auction.delay", "1000");
    }

    @Override
    public boolean placeBid(String bidder, int amount) {
        System.out.println(bidder + ": " + amount);
        boolean toReturn = false;
        final Artwork artwork = offerings.getArtworks().filter(kunst -> !((Artwork) kunst).isAuctioned()).findFirst().orElseThrow(IllegalStateException::new);
        if ((bidder != null) && !bidder.isEmpty() && amount > offerings.getBid() && amount > artwork.getInitialPrice()) {
            offerings.setBidder(bidder);
            offerings.setBid(amount);
            toReturn = true;
            newBid = true;
        }
        return toReturn;
    }

    @Override
    public void run() {
        offerings.getArtworks().forEach((MutableArtwork artwork) -> {
            offerings.setStepsRemaining(FIVE);
            while (offerings.getStepsRemaining() > 0) {
                offerings.notifyObservers();
                synchronized (this) {
                    try {
                        this.wait(Long.parseLong(System.getProperty("auction.delay")));
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                if (newBid) {
                        newBid = false;
                        offerings.setStepsRemaining(FIVE);
                } else {
                    offerings.setStepsRemaining(offerings.getStepsRemaining() - 1);
                }
            }
            offerings.notifyObservers();
            if (newBid) {
                newBid = false;
                artwork.setSoldPrice(offerings.getBid());
                offerings.setBid(0);
            }
            artwork.setAuctioned(true);
        });
        offerings.notifyObservers();
    }

    private void stepBack() {
        if (offerings.getStepsRemaining() > 0)
            offerings.setStepsRemaining(offerings.getStepsRemaining() - 1);
    }
}

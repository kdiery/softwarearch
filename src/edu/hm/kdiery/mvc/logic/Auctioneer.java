package edu.hm.kdiery.mvc.logic;
import edu.hm.kdiery.mvc.datastore.readonly.Offerings;
import edu.hm.kdiery.mvc.datastore.writable.MutableOfferings;

public interface Auctioneer extends Runnable {

    /**
     * if bidder ok and amount higher that last bid return true
     * @param bidder name of bidder
     * @param amount bid amount
     * @return true/false
     */
    boolean placeBid(String bidder, int amount);


    /**
     * Factory method for auctioneer.
     * @param offerings of auction
     * @return auctioneer
     */
    default Auctioneer make(MutableOfferings offerings) {
        return new ConcreteAuctioneer(offerings);
    }
}

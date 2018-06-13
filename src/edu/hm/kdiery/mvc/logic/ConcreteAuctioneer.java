package edu.hm.kdiery.mvc.logic;

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
	 * Ctor of ConcreteAuctioneer.
	 *
	 * @param offerings
	 *            of auction
	 */
	public ConcreteAuctioneer(final MutableOfferings offerings) {
		this.offerings = offerings;
	}

	@Override
	public boolean placeBid(String bidder, int amount) {
		return ((bidder != null) && !bidder.isEmpty()) && (amount > offerings.getBid());
	}

	@Override
	public void run() {
		offerings.getArtworks().forEach((MutableArtwork artwork) -> {
			offerings.setStepsRemaining(FIVE);
			while (offerings.getStepsRemaining() > 0) {
				offerings.notifyObservers();
				// wait here
				if (placeBid("lol", 2)) { // TODO auf was horchen?
					offerings.setStepsRemaining(FIVE);
				} else {
					offerings.setStepsRemaining(offerings.getStepsRemaining() - 1);
				}
			}
			offerings.notifyObservers();
			if (placeBid("lol", 2)) {
				artwork.setSoldPrice(offerings.getBid());
				offerings.setBid(0);
				// Gebot löschen.
			}
			artwork.setAuctioned(true);
		});
		offerings.notifyObservers();
	}
}

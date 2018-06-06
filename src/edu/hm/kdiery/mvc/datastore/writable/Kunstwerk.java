package edu.hm.kdiery.mvc.datastore.writable;

/**
 * conrecte class for database.
 */
class Kunstwerk extends MutableArtwork {

	/**
	 * title of artwork.
	 */
	private final String title;

	/**
	 * start price of artwork.
	 */
	private final int initialPrice;

	/**
	 * boolean for if artwork has been sold.
	 */
	private boolean auctioned;

	/**
	 * name of the buyer of artwork.
	 */
	private String buyer;

	/**
	 * price for what artwork has been sold.
	 */
	private int soldPrice = 0;

	private AllOffers datastore;

	/**
	 * constructor for artwork.
	 *
	 * @param title
	 *            of artwork
	 * @param initialPrice
	 *            of artwork
	 * @throws IllegalArgumentException
	 *             if negative initialPrice
	 */
	Kunstwerk(String title, int initialPrice) throws IllegalArgumentException {
		this.title = title;
		if (initialPrice >= 0) {
			this.initialPrice = initialPrice;
		} else {
			throw new IllegalArgumentException();
		}
		this.auctioned = false;
		this.buyer = null;
		this.soldPrice = 0;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getInitialPrice() {
		return initialPrice;
	}

	@Override
	public boolean isAuctioned() {
		return auctioned;
	}

	/**
	 * sets auctioned.
	 *
	 * @param auctioned
	 *            to be set
	 */
	@Override
	public void setAuctioned(boolean auctioned) {
		this.auctioned = auctioned;
		if (datastore != null)
			datastore.ChangeData();
	}

	@Override
	public String getBuyer() {
		return buyer;
	}

	/**
	 * sets name of buyer.
	 *
	 * @param buyer
	 *            to be set
	 */
	@Override
	public void setBuyer(String buyer) {
		this.buyer = buyer;
		if (datastore != null)
			datastore.ChangeData();
	}

	@Override
	public int getSoldPrice() {
		return soldPrice;
	}

	/**
	 * only accepts non negative values.
	 *
	 * @param soldPrice
	 *            of artwork.
	 * @throws IllegalArgumentException
	 *             if not acceptable input
	 */
	@Override
	public void setSoldPrice(int soldPrice) throws IllegalArgumentException {
		if (soldPrice > 0) {
			this.soldPrice = soldPrice;
			if (datastore != null)
				datastore.ChangeData();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void setOfferings(AllOffers datastore) {
		this.datastore = datastore;
	}
}

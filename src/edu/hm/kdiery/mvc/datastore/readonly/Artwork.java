package edu.hm.kdiery.mvc.datastore.readonly;

/**
 * abstract class for artwork.
 */
public abstract class Artwork {

	/**
	 * returns title.
	 * @return title.
	 */
    public abstract String getTitle();

    /**
     * returns buyer.
     * @return buyer
     */
    public abstract String getBuyer();

    /**
     * returns wether artwork has been auctioned.
     * @return auctioned
     */
    public abstract boolean isAuctioned();

    /**
     * returns initial price of artwork.
     * @return initial price
     */
    public abstract int getInitialPrice();

    /**
     * returns sold price of artwork.
     * @return sold price
     */
    public abstract int getSoldPrice();


}

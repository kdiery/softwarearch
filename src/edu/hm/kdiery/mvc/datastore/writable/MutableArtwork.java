package edu.hm.kdiery.mvc.datastore.writable;

import edu.hm.kdiery.mvc.datastore.readonly.Artwork;

/**
 * abstract class for MutableArtwork.
 */
public abstract class MutableArtwork extends Artwork {

    /**
     * returns an instant of a Artwork.
     * @param title of artwork
     * @param initialPrice initial price
     * @return Kunstwerk
     */
    public static MutableArtwork make(String title, int initialPrice) {
        return new Kunstwerk(title, initialPrice);
    }

    /**
     * sets auctioned.
     * @param auctioned to be set
     */
    public abstract void setAuctioned(boolean auctioned);

    /**
     * set sold price of artwork.
     * @param soldPrice to be set
     */
    public abstract void setSoldPrice(int soldPrice);

    /**
     * set name of buyer.
     * @param buyer to be set
     */
    public abstract void setBuyer(String buyer);
    
    public abstract void setOfferings(AllOffers datastore);
}

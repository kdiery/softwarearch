package MVC.edu.hm.kdiery.datastore.writable;

/**
 * conrecte class for database.
 */
public class Kunstwerk {

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

    /**
     * constructor for artwork.
     *
     * @param title        of artwork
     * @param initialPrice of artwork
     * @throws IllegalArgumentException if negative initialPrice
     */
    public Kunstwerk(String title, int initialPrice) throws IllegalArgumentException {
        this.title = title;
        if (initialPrice > 0) {
            this.initialPrice = initialPrice;
        } else {
            throw new IllegalArgumentException();
        }
        this.auctioned = false;
        this.buyer = null;
        this.soldPrice = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getInitialPrice() {
        return initialPrice;
    }

    public boolean isAuctioned() {
        return auctioned;
    }

    public void setAuctioned(boolean auctioned) {
        this.auctioned = auctioned;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getSoldPrice() {
        return soldPrice;
    }

    /**
     * only accepts non negative values.
     * @param soldPrice of artwork.
     * @throws IllegalArgumentException if not acceptable input
     */
    public void setSoldPrice(int soldPrice) throws IllegalArgumentException {
        if (soldPrice > 0) {
            this.soldPrice = soldPrice;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

package mvc.edu.hm.kdiery.datastore.readonly;

import java.util.Observable;

public abstract class Artwork extends Observable {

    public String getTitle() {
        return null;
    }

    public abstract String getBuyer();

    public abstract boolean isAuctioned();

    public abstract int getInitialPrice();

    public abstract int getSoldPrice();


}

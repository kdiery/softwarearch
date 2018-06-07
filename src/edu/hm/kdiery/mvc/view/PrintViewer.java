package edu.hm.kdiery.mvc.view;

import edu.hm.kdiery.mvc.datastore.readonly.Artwork;
import edu.hm.kdiery.mvc.datastore.readonly.Offerings;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Writes to PrintWriter every update.
 */
class PrintViewer implements Viewer {
	
	/**
	 * Magic Number 3.
	 */
	private static final int THREE = 3;
	
	/**
	 * Magic Number 4.
	 */
	private static final int FOUR = 4;
	
	/**
	 * Magic Number 5.
	 */
	private static final int FIVE = 5;

    /**
     * Writer to write to.
     */
    private final PrintWriter writer;

    /**
     * Offerings of auction.
     */
    private final Offerings offerings;

    /**
     * text to be printed if no bid.
     */
    private final Map<Integer, String> noBidMap;

    /**
     * text to be printed if bid.
     */
    private final Map<Integer, String> bidMap;

    /**
     * constructor for PrintViewer.
     *
     * @param writer    to be written to
     * @param offerings of auction
     */
    /* default */PrintViewer(PrintWriter writer, Offerings offerings) {
        this.writer = writer;
        this.offerings = offerings;
        noBidMap = new HashMap<>();
        noBidMap.put(0, Callout.Done.getFormatNobid());
        noBidMap.put(1, Callout.Going2nd.getFormatNobid());
        noBidMap.put(2, Callout.Going1st.getFormatNobid());
        noBidMap.put(THREE, Callout.Remaining3.getFormatNobid());
        noBidMap.put(FOUR, Callout.Remaining4.getFormatNobid());
        noBidMap.put(FIVE, Callout.NewBid.getFormatNobid());
        bidMap = new HashMap<>();
        bidMap.put(0, Callout.Done.getFormatBid());
        bidMap.put(1, Callout.Going2nd.getFormatBid());
        bidMap.put(2, Callout.Going1st.getFormatBid());
        bidMap.put(THREE, Callout.Remaining3.getFormatBid());
        bidMap.put(FOUR, Callout.Remaining4.getFormatBid());
        bidMap.put(FIVE, Callout.NewBid.getFormatBid());
        offerings.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        final Artwork artwork = offerings.getArtworks().filter(kunst -> !((Artwork) kunst).isAuctioned()).findFirst().orElseThrow(IllegalStateException::new);
        writer.printf(artwork.getTitle() + ": ");
        if (offerings.getBidder() == null) {
            writer.printf(noBidMap.get(offerings.getStepsRemaining()) + "\n", artwork.getInitialPrice());
        } else {
            writer.printf(bidMap.get(offerings.getStepsRemaining()) + "\n", offerings.getBid());
        }
        writer.flush();
    }

}

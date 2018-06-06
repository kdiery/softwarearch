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
    PrintViewer(PrintWriter writer, Offerings offerings) {
        this.writer = writer;
        this.offerings = offerings;
        noBidMap = new HashMap<>();
        noBidMap.put(0, Callout.Done.getFormatNobid());
        noBidMap.put(1, Callout.Going1st.getFormatNobid());
        noBidMap.put(2, Callout.Going2nd.getFormatNobid());
        noBidMap.put(3, Callout.Remaining3.getFormatNobid());
        noBidMap.put(4, Callout.Remaining4.getFormatNobid());
        noBidMap.put(5, Callout.NewBid.getFormatNobid());
        bidMap = new HashMap<>();
        noBidMap.put(0, Callout.Done.getFormatBid());
        noBidMap.put(1, Callout.Going1st.getFormatBid());
        noBidMap.put(2, Callout.Going2nd.getFormatBid());
        noBidMap.put(3, Callout.Remaining3.getFormatBid());
        noBidMap.put(4, Callout.Remaining4.getFormatBid());
        noBidMap.put(5, Callout.NewBid.getFormatBid());
        offerings.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        final Artwork artwork = offerings.getArtworks().filter(p -> !((Artwork) p).isAuctioned()).findFirst().orElseThrow(IllegalStateException::new);
        writer.printf(artwork.getTitle() + ": ");
        if (offerings.getBidder().equals(null)) {
            writer.printf(noBidMap.get(offerings.getStepsRemaining()), artwork.getInitialPrice());
        } else {
            writer.printf(bidMap.get(offerings.getStepsRemaining()), offerings.getBid());
        }
        writer.flush();
    }

}

package edu.hm.kdiery.mvc.view;

import edu.hm.kdiery.mvc.datastore.readonly.Artwork;
import edu.hm.kdiery.mvc.datastore.readonly.Offerings;

import java.io.PrintWriter;
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
     * constructor for PrintViewer.
     *
     * @param writer    to be written to
     * @param offerings of auction
     */
    PrintViewer(PrintWriter writer, Offerings offerings) {
        this.writer = writer;
        this.offerings = offerings;
        offerings.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        final Artwork artwork = offerings.getArtworks().filter(p -> !((Artwork) p).isAuctioned()).findFirst().orElseThrow(IllegalStateException::new);
        writer.printf(artwork.getTitle() + ": ");
        final int remainingSteps = offerings.getStepsRemaining();
        //TODO das hier als map dann!
        if (offerings.getBidder().equals(null)) {
            if (remainingSteps == 5) {
                writer.printf(Callout.NewBid.getFormatNobid(), artwork.getInitialPrice());
            } else if (remainingSteps == 4) {
                writer.printf(Callout.Remaining4.getFormatNobid(), artwork.getInitialPrice());
            } else if (remainingSteps == 3) {
                writer.printf(Callout.Remaining3.getFormatNobid(), artwork.getInitialPrice());
            } else if (remainingSteps == 2) {
                writer.printf(Callout.Going2nd.getFormatNobid(), artwork.getInitialPrice());
            } else if (remainingSteps == 1) {
                writer.printf(Callout.Going1st.getFormatNobid(), artwork.getInitialPrice());
            } else if (remainingSteps == 0) {
                writer.printf(Callout.Done.getFormatNobid());
            }
        } else {
            if (remainingSteps == 5) {
                writer.printf(Callout.NewBid.getFormatBid(), offerings.getBid());
            } else if (remainingSteps == 4) {
                writer.printf(Callout.Remaining4.getFormatBid(), offerings.getBid());
            } else if (remainingSteps == 3) {
                writer.printf(Callout.Remaining3.getFormatBid(), offerings.getBid());
            } else if (remainingSteps == 2) {
                writer.printf(Callout.Going2nd.getFormatBid(), offerings.getBid());
            } else if (remainingSteps == 1) {
                writer.printf(Callout.Going1st.getFormatBid(), offerings.getBid());
            } else if (remainingSteps == 0) {
                writer.printf(Callout.Done.getFormatBid(), offerings.getBid());
            }
            writer.flush();
        }
    }
}

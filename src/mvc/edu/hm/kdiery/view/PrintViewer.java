package mvc.edu.hm.kdiery.view;

import mvc.edu.hm.kdiery.datastore.readonly.Offerings;

import java.io.PrintWriter;
import java.util.Observable;

/**
 * Writes to PrintWriter every update.
 */
public class PrintViewer implements Viewer {

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
    public void update(Observable o, Object arg) {
         switch (offerings.getStepsRemaining()) {
             case 5:
                 writer.println(Callout.NewBid.getFormatNobid());
                 break;
             case 4:
                 writer.println(Callout.Remaining4.getFormatNobid());
                 break;
             case 3:
                 writer.println(Callout.Remaining3.getFormatNobid());
                 break;
             case 2:
                 writer.println(Callout.Going2nd.getFormatNobid());
                 break;
             case 1:
                 writer.println(Callout.Going1st.getFormatNobid());
                 break;
             case 0:
                 writer.println(Callout.Done.getFormatNobid());
                 break;
         }
        writer.flush();
    }
}

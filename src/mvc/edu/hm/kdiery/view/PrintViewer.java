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
    public PrintViewer(PrintWriter writer, Offerings offerings) {
        this.writer = writer;
        this.offerings = offerings;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

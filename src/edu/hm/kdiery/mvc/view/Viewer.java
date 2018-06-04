package edu.hm.kdiery.mvc.view;

import java.io.PrintWriter;
import java.util.Observer;

import edu.hm.kdiery.mvc.datastore.readonly.Offerings;

/**
 * Basis for all views.
 */
public interface Viewer extends Observer {

    /**
     * produces viewers.
     *
     * @param typekey   type of view
     * @param offerings of auction
     * @param args      arguments of viewers
     * @return viewer
     */
    static Viewer make(String typekey, Offerings offerings, Object... args) {
        Viewer viewer = null;
        if ("spectator".equals(typekey)) {
            viewer = new PrintViewer((PrintWriter) args[0], offerings);
        } else if ("logger".equals(typekey)) {
            viewer = new FileViewer();
        }

        return viewer;
    }

}

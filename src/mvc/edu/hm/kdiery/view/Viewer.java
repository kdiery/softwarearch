package mvc.edu.hm.kdiery.view;

import java.util.Observer;

import mvc.edu.hm.kdiery.datastore.readonly.Offerings;

/**
 * Basis for all views.
 */
public interface Viewer extends Observer {

    /**
     * produces viewers.
     * @param typekey type of view
     * @param offerings of auction
     * @param args arguments of viewers
     * @return viewer
     */
    static Viewer make(String typekey, Offerings offerings, Object... args) {
        return null;
    }

}

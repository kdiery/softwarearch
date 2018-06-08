package edu.hm.kdiery.mvc.view;

//import java.io.*;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Observable;

import edu.hm.kdiery.mvc.datastore.readonly.Offerings;

/**
 * writes databasis to auction.n.log.
 */
class FileViewer implements Viewer {

    /**
     * counter update for logger call.
     */
    private int updateCount;

    /**
     * offerings variable for properties.
     */
    private final Offerings offerings;

    /**
     * Constructor of this class.
     *
     * @param offerings to be set
     */
    /* default */FileViewer(Offerings offerings) {
        this.offerings = offerings;
        offerings.addObserver(this);
        this.updateCount = 0;
    }

    @Override
    public void update(Observable observable, Object arg) {
        final String homeDir = System.getProperty("java.io.tmpdir");
        System.out.printf(System.getProperty("java.io.tmpdir"));
        final String file = "auction." + updateCount + ".log";
        try {
            final OutputStream write = Files.newOutputStream(Paths.get(homeDir+file));
            Viewers.printProperties(offerings, write);
        } catch (FileNotFoundException exe) {
            System.out.println("File not found");
        } catch (IOException exce) {
            System.out.println("IO-Exception");
        }
        updateCount++;
    }
}

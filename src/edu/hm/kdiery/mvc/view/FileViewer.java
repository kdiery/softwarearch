package edu.hm.kdiery.mvc.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Observable;

import edu.hm.kdiery.mvc.datastore.readonly.Offerings;

/**
 * writes databasis to auction.n.log.
 */
class FileViewer implements Viewer {

	/**
	 * counter update for logger call.
	 */
	private int updateCount = 0;

	/**
	 * offerings variable for properties.
	 */
	private final Offerings offerings;

	/**
	 * Constructor of this class.
	 * 
	 * @param offerings
	 *            to be set
	 */
	/* default */FileViewer(Offerings offerings) {
		this.offerings = offerings;
	}

	@Override
	public void update(Observable observable, Object arg) {
		final String homeDir = System.getProperty("java.io.tmpdir");
		final File file = new File(homeDir + "auction." + updateCount + ".log");
		try {
			final OutputStream write = new FileOutputStream(file);
			Viewers.printProperties(offerings, write);
		} catch (FileNotFoundException exe) {
			System.out.println("File not found");
		} catch (IOException exce) {
			System.out.println("IO-Exception");
		}
		updateCount++;
	}
}

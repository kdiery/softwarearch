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

	private int update = 0;

	Offerings offerings;

	public FileViewer(Offerings offerings) {
		this.offerings = offerings;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		String homeDir = System.getProperty("java.io.tmpdir");
		System.out.println(homeDir);
		File file = new File(homeDir + "auction." + update + ".log");
		try {
			OutputStream write = new FileOutputStream(file);
			Viewers.printProperties(offerings, write);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		update++;
	}
}

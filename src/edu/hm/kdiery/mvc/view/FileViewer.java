package edu.hm.kdiery.mvc.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;


/**
 * writes databasis to auction.n.log.
 */
class FileViewer implements Viewer {
	
	private int update = 0;


	// Beider dieser Methode die Datenbasis schreiben.
	// Hab aktuell einfach irgendwas rein geschrieben.
    @Override
    public void update(Observable observable, Object arg) {
    	String homeDir = System.getProperty("java.io.tmpdir");
    	System.out.println(homeDir);
		try {
			@SuppressWarnings("resource")
			FileWriter write = new FileWriter(homeDir +"auction." + update + ".log");
			write.write(arg.toString());
			write.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		update++;
    }
}

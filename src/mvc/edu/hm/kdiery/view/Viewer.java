package mvc.edu.hm.kdiery.view;

import java.util.Observer;
import mvc.edu.hm.kdiery.datastore.readonly.Offerings;

public interface Viewer extends Observer {

	static Viewer make(String typekey, Offerings offerings, Object... args) {
		return null;		
	}

}

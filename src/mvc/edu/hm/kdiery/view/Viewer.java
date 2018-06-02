package mvc.edu.hm.kdiery.view;

import mvc.edu.hm.kdiery.datastore.readonly.Offerings;

public interface Viewer {


Viewer make(String typekey, Offerings offerings, Object... args);

	
}

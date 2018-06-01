package MVC.edu.hm.kdiery.view;

import MVC.edu.hm.kdiery.datastore.readonly.Offerings;

public interface Viewer {


Viewer make(String typekey, Offerings offerings, Object... args);

	
}

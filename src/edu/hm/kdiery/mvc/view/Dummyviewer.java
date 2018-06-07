package edu.hm.kdiery.mvc.view;

import java.util.Observable;

/**
 * class of Dummyviewer.
 * @author Duc, Kristina
 *
 */
public class Dummyviewer implements Viewer {

	/**
	 * Empty method.
	 */
	@Override
	public void update(Observable obserab, Object arg) {
		if (arg != null)
			throw new IllegalArgumentException();
	}

}

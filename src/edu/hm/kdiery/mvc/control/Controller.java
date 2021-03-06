package edu.hm.kdiery.mvc.control;

import edu.hm.kdiery.mvc.logic.Auctioneer;

/**
 * abstract class for controller.
 */
public abstract class Controller extends Thread {

	/**
	 * Factory method for Controllers.
	 * 
	 * @param viewer
	 *            name
	 * @param auctioneer
	 *            auctioneer
	 * @param args
	 *            arguments for Controller
	 * @return
	 */
	public static Controller make(final String viewer, final Auctioneer auctioneer, final String... args) {
		Controller controller = null;
		if ("CONSOLE".equals(viewer.toUpperCase())) {
			controller = new ConsoleController(auctioneer);
		} else if ("ROBOT".equals(viewer.toUpperCase())) {
			controller = new RobotTrader(auctioneer, args);
		}
		return controller;
	}

}

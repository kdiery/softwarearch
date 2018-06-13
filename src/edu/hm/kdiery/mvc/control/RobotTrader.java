package edu.hm.kdiery.mvc.control;

import edu.hm.kdiery.mvc.logic.Auctioneer;

/**
 * Controller with lists of bids.
 */
public class RobotTrader extends Controller {

    /**
     * name of controller
     */
    private static final String CONTROLLERNAME = "Robot-";

    /**
     * auctioneer of auction.
     */
    private final Auctioneer auctioneer;

    /**
     * String array of bids.
     */
    private final String[] arguments;

    /**
     * Ctor for RobotTrader
     * @param auctioneer of auction
     * @param args bids
     */
    public RobotTrader(final Auctioneer auctioneer, String... args) {
        this.auctioneer = auctioneer;
        this.arguments = args;
    }
    
    @Override
    public void run() {
    	
    }
}

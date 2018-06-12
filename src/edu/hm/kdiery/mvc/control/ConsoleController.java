package edu.hm.kdiery.mvc.control;

import edu.hm.kdiery.mvc.logic.Auctioneer;

/**
 * Controller reads from Console.
 */
public class ConsoleController extends Controller {


    /**
     * name of controller.
     */
    private static final String CONTROLLERNAME = "Console";

    /**
     * auctioneer of auction.
     */
    private final Auctioneer auctioneer;


    /**
     * Ctor for ConsoleController.
     * @param auctioneer of auction
     */
    public ConsoleController(final Auctioneer auctioneer) {
        this.auctioneer = auctioneer;
    }
}

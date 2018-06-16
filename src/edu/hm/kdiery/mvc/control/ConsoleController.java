package edu.hm.kdiery.mvc.control;

import java.util.InputMismatchException;
import java.util.Scanner;

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
     * Scanner to read the bid.
     */
    private Scanner scan;

    /**
     * Ctor for ConsoleController.
     *
     * @param auctioneer of auction
     */
    public ConsoleController(final Auctioneer auctioneer) {
        setDaemon(true);
        this.auctioneer = auctioneer;
        scan = new Scanner(System.in);
    }

    @Override
    public void run() {
        String input = "";
        int bid = 0;
        while (true) {
            synchronized (this) {
                try {
                    input = scan.nextLine();
                    bid = Integer.parseInt(input);
                } catch (NumberFormatException ex) {

                }
                auctioneer.placeBid(CONTROLLERNAME, bid);
            }
        }
    }
}

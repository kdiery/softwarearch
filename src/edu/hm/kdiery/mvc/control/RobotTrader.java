package edu.hm.kdiery.mvc.control;

import edu.hm.kdiery.mvc.logic.Auctioneer;

import java.util.*;

/**
 * Controller with lists of bids.
 */
public class RobotTrader extends Controller {

    /**
     * name of controller
     */
    private final String controllername;

    /**
     * auctioneer of auction.
     */
    private final Auctioneer auctioneer;

    /**
     * String array of bids.
     */
//    private final String[] arguments;

    private final Map<Long, Integer> arguments;

    /**
     * Ctor for RobotTrader
     *
     * @param auctioneer of auction
     * @param args       bids
     */
    public RobotTrader(final Auctioneer auctioneer, String... args) {
        setDaemon(true);
        this.auctioneer = auctioneer;
//        this.arguments = args;
        Long time = (long) 0;
        arguments = new TreeMap<>();
        for (String string : args) {
            final String[] timeamount = string.split(":");
            time += Long.parseLong(timeamount[0]);
            arguments.put(Long.parseLong(timeamount[0]), Integer.parseInt(timeamount[1]));
        }
        this.controllername = "Robot-" + time.toString();
    }

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                for (Long l : arguments.keySet()) {
                    try {
                        sleep(l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(l);
                    auctioneer.placeBid(controllername, arguments.get(l));
                    this.notifyAll();
                }
            }
        }
    }
}

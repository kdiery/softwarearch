package edu.hm.kdiery.mvc.view;/* (C) 2018, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_121, Linux i386 4.15.4
 * bluna: Intel Core i7-5600U/2600 MHz, 4 Core(s), 15936 MByte RAM
 **/

import edu.hm.kdiery.mvc.control.Controller;
import edu.hm.kdiery.mvc.datastore.writable.MutableArtwork;
import edu.hm.kdiery.mvc.datastore.writable.MutableOfferings;
import edu.hm.kdiery.mvc.logic.Auctioneer;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Hauptprogramm zur Aufgabe MVC.
 *
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2018-05-20
 */
public class Sotherbys {

    /**
     * Entry-Point.
     *
     * @param args Kommandozeilenargumente:
     *             1. Liste von Kunstwerken, mit Kommas getrennt. Jedes Kunstwerk in der Form "Name/Preis".
     *             2. Liste von Views, mit Kommas getrennt. Jede View "Name/Argument1/Argument2/...".
     *             3. Liste von Controls, mit Kommas getrennt. Jedes Control "Name/Argument1/Argument2/...".
     *             Beispiel:
     *             $ java -ea -Dauction.delay=1000 edu.hm.kdiery.mvc.view.Sotherbys \
     *             MonaLisa/2000,MickyMaus/1000 \
     *             spectator \
     *             robot/500=2500/8000=5000
     */
    public static void main(String... args) {

        System.setProperty("auction.delay", "3000");
        // zerlegt ein Kommandozeilenargument in einen Stream von Wort-Arrays
        final Function<Integer, Stream<String[]>> argSplitter = index -> Stream.of(args[index].split(","))
                .filter(arg -> !arg.isEmpty())
                .map(arg -> arg.split("/"));

        // datastore
        final MutableArtwork[] artworks = argSplitter.apply(0)
                .map(nameAndPrice -> MutableArtwork.make(nameAndPrice[0],
                        Integer.parseInt(nameAndPrice[1])))
                .toArray(MutableArtwork[]::new);
        final MutableOfferings offerings = MutableOfferings.make(artworks);

        // logic
        final Auctioneer auction = Auctioneer.make(offerings);

        // viewers
        argSplitter.apply(1)
                .forEach(typeAndArgs -> Viewer.make(typeAndArgs[0],
                        offerings,
                        new PrintWriter(System.out)));
//                        (Object[])Arrays.copyOfRange(typeAndArgs, 1, typeAndArgs.length)));

        // controller
        argSplitter.apply(2)
                .map(typeAndArgs -> Controller.make(typeAndArgs[0],
                        auction,
                        Arrays.copyOfRange(typeAndArgs, 1, typeAndArgs.length)))
                .map(Thread::new)
                .forEach(Thread::start);

        new Thread(auction).start();

    }
}

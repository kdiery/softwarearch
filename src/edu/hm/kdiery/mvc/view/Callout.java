/* (C) 2018, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_121, Linux i386 4.15.4
 * bluna: Intel Core i7-5600U/2600 MHz, 4 Core(s), 15936 MByte RAM
 **/
package edu.hm.kdiery.mvc.view;

/**
 * Nachrichtentexte fuer einen Viewer, der auf System.out protokolliert.
 *
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2018-05-21
 */
public enum Callout {
	/**
	 * Die Ordnungsnummer der Nachrichten entspricht der Anzahl verbleibender
	 * Schritte.
	 */
	Done("%d zum Dritten, verkauft!", "Keine Gebote, nicht verkauft."),
	/**
	 * Going2nd to count.
	 */
	Going2nd("%d zum Zweiten ...", "%d zum Zweiten ..."),
	/**
	 * Going1st to count.
	 */
	Going1st("%d zum Ersten ...", "%d zum Ersten ..."),
	/**
	 * 3 steps remaining to count.
	 */
	Remaining3("noch %d geboten, hoere ich mehr?", "Mindestgebot noch %d, bietet jemand?"),
	/**
	 * 4 steps remaining to count.
	 */
	Remaining4("%d geboten, hoere ich mehr?", "Mindestgebot %d, bietet jemand?"),
	/**
	 * If a bidder bids.
	 */
	NewBid("%d geboten!", "Mindestgebot %d");

	/**
	 * Nachrichtentext mit Gebot.
	 */
	private final String formatBid;

	/**
	 * Nachrichtentext ohne Gebot.
	 */
	private final String formatNobid;

	/**
	 * set the format bids.
	 * 
	 * @param formatBid
	 *            if a bidder already bids.
	 * @param formatNobid
	 *            if no bidder bids for a artwork.
	 */
	Callout(String formatBid, String formatNobid) {
		this.formatBid = formatBid;
		this.formatNobid = formatNobid;
	}

	/**
	 * gets the actual step.
	 * 
	 * @return String.
	 */
	public String getFormatNobid() {
		return formatNobid;
	}

	/**
	 * gets the actual step of no bidder.
	 * @return String.
	 */
	public String getFormatBid() {
		return formatBid;
	}
}
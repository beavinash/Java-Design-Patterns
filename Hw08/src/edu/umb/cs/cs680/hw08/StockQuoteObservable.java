/**
 * 
 */
package edu.umb.cs.cs680.hw08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author avinashreddy
 *
 */
public class StockQuoteObservable extends Observable {
	private Map<String,Float> quoteMap;

	public StockQuoteObservable() {
		quoteMap = new HashMap<>();
	}

	public void changeQuote(String ticker, float quote) throws IllegalArgumentException {
		quoteMap.put(ticker, quote);
		this.setChanged();
		this.notifyObservers(new StockEvent(quote, ticker));
	}
}

/**
 * 
 */
package edu.umb.cs.cs680.hw08;

/**
 * @author avinashreddy
 *
 */
public class ThreeDObserver extends Observer {
	public ThreeDObserver() { }

    @Override
    public void update(Observable o, Object arg) {
        StockEvent stock_obj = (StockEvent) arg;
        System.out.println("Drawing 3DGRAPH for "+stock_obj.getTicker()+" with updated quote of "+stock_obj.getQuote());
    }
}

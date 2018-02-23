/**
 * 
 */
package edu.umb.cs.cs680.hw08;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umb.cs.cs680.hw08.PieChartObserver;
import edu.umb.cs.cs680.hw08.StockQuoteObservable;
import edu.umb.cs.cs680.hw08.TableObserver;
import edu.umb.cs.cs680.hw08.ThreeDObserver;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;



/**
 * @author avinashreddy
 *
 */
public class MulticastStockObservableTest {

	private StockQuoteObservable stock;
	private Random randomizer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void init(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

		PieChartObserver pieObserver = new PieChartObserver();
		TableObserver tableObserver = new TableObserver();
		ThreeDObserver threeDObserver = new ThreeDObserver();
		this.stock = new StockQuoteObservable();
		this.randomizer = new Random();

		this.stock.addObserver(pieObserver);
		this.stock.addObserver(tableObserver);
		this.stock.addObserver(threeDObserver);
	}

	@Test
	public void testChangeQuoteStockEvent() throws IllegalArgumentException {
        int i = 0;
        while(i<3) {
            this.stock.changeQuote("Sample", (this.randomizer.nextFloat() * 20));
            assertTrue(outContent.toString().contains("Drawing PIECHART"));
            assertTrue(outContent.toString().contains("Drawing TABLE"));
            assertTrue(outContent.toString().contains("Drawing 3DGRAPH"));
            i++;
        }
	}

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}

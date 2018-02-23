/**
 *
 */
package edu.umb.cs.cs680.hw07;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


import org.junit.Test;

/**
 * @author avinashreddy
 *
 */
public class FifoTest {

	
		@Test
		public void fifoThreeTest() {
			// TODO Auto-generated method stub

			String actual;
			String expected;


			FileCache fCache = new FileCache();
			fCache.changePolicy(new FIFO());
			actual = fCache.fetch("three.txt");

			expected = "Third preferred programing language is Java programming.";

			assertThat(actual, is(expected));



		}

		@Test
		public void fifoOneTest() {
			// TODO Auto-generated method stub

			String actual;
			String expected;


			FileCache fCache = new FileCache();
			fCache.changePolicy(new FIFO());
			actual = fCache.fetch("one.txt");

			expected = "First programming language is Swift iOS programming.";

			assertThat(actual, is(expected));



		}

	}

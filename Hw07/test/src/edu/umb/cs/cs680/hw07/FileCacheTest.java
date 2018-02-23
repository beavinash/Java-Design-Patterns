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
public class FileCacheTest {

	@Test
	public void fetchOneTest() {
		// TODO Auto-generated method stub

		String actual;
		String expected;



		FileCache fCache = FileCache.getInstance();
		actual = fCache.fetch("one.txt");

		expected = "First programming language is Swift iOS programming.";

		assertThat(actual, is(expected));



	}

	@Test
	public void fetchTwoTest() {
		// TODO Auto-generated method stub

		String actual;
		String expected;


		FileCache fCache = FileCache.getInstance();
		actual = fCache.fetch("two.txt");

		expected = "Second preferred programing language is Python programming.";

		assertThat(actual, is(expected));



	}

	@Test
	public void fetchThreeTest() {
		// TODO Auto-generated method stub

		String actual;
		String expected;


		FileCache fCache = FileCache.getInstance();
		actual = fCache.fetch("three.txt");

		expected = "Third preferred programing language is Java programming.";

		assertThat(actual, is(expected));



	}

	@Test
	public void fetchFourTest() {
		// TODO Auto-generated method stub

		String actual;
		String expected;



		FileCache fCache = FileCache.getInstance();


		fCache.fetch("one.txt");
		fCache.fetch("two.txt");
		fCache.fetch("three.txt");
		fCache.fetch("one.txt");
		fCache.fetch("two.txt");
		fCache.fetch("three.txt");
		actual = fCache.fetch("four.txt");

		expected = "Fourth programming language is Swift iOS programming.";

		assertThat(actual, is(expected));



	}
/*
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



	}*/

}

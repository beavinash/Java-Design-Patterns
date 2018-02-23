package edu.umb.cs.cs680.hw02;

import static org.junit.Assert.*; 
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
public class DVDPlayerTest {

	@Test
	public void test() {
		DVDPlayer dvd = DVDPlayer.getInstance();
		DVDPlayer dvd2 = DVDPlayer.getInstance();
		assertThat(dvd, is(dvd2));
	}

}

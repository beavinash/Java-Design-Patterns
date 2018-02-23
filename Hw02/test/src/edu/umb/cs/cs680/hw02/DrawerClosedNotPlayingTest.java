/**
 * 
 */
package edu.umb.cs.cs680.hw02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;



/**
 * @author avinashreddy
 *
 */
public class DrawerClosedNotPlayingTest {
	
	DrawerClosedNotPlaying av = DrawerClosedNotPlaying.getInstance();

	@Test
	public void testOpenClosedButtonPushed() {
		DVDPlayer dvd = DVDPlayer.getInstance();
		dvd.changeState(DrawerClosedNotPlaying.getInstance());
		dvd.openCloseButtonPushed();
		assertThat(dvd.st, is(DrawerOpen.getInstance()));
	}
	@Test
	public void testPlayButtonPushed() {
		DVDPlayer dvd = DVDPlayer.getInstance();
		dvd.changeState(DrawerClosedNotPlaying.getInstance());
		dvd.playButtonPushed();
		assertThat(dvd.st, is(DrawerClosedPlaying.getInstance()));
	}
	@Test
	public void testStopButtonPushed() {
		DVDPlayer dvd = DVDPlayer.getInstance();
		dvd.changeState(DrawerClosedNotPlaying.getInstance());
		dvd.stopButtonPushed();
		assertThat(dvd.st, is(DrawerClosedNotPlaying.getInstance()));
	}

}

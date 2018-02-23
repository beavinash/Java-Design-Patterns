/**
 * 
 */
package edu.umb.cs.cs680.hw02;

/**
 * @author avinashreddy
 *
 */
public class DrawerClosedNotPlaying implements State {
	private DrawerClosedNotPlaying() {
		// TODO Auto-generated constructor stub
	}
	
	public static DrawerClosedNotPlaying instance = null;
	

	
	public static DrawerClosedNotPlaying getInstance() {
		if (instance == null) {
			instance = new DrawerClosedNotPlaying();	
		}
		return instance;
	}
	@Override
	public void openCloseButtonPushed(DVDPlayer av) {
		av.open();
		av.changeState(DrawerOpen.getInstance());
	}
	@Override
	public void playButtonPushed(DVDPlayer av) {
		av.play();
		av.changeState(DrawerClosedPlaying.getInstance());
	}
	@Override
	public void stopButtonPushed(DVDPlayer av) {
		
	}
}

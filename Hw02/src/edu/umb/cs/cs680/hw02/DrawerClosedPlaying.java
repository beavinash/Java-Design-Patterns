/**
 * 
 */
package edu.umb.cs.cs680.hw02;

/**
 * @author avinashreddy
 *
 */
public class DrawerClosedPlaying implements State{
	private DrawerClosedPlaying() {
		// TODO Auto-generated constructor stub
	}
	
	public static DrawerClosedPlaying instance = null;
	

	
	public static DrawerClosedPlaying getInstance() {
		if (instance == null) {
			instance = new DrawerClosedPlaying();
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
	}
	
	@Override
	public void stopButtonPushed(DVDPlayer av) {
		System.out.println("Stopped");
		boolean t = true;
		if (t == true) {
			av.stop();
			av.changeState(DrawerClosedNotPlaying.getInstance());
		}
	}
}

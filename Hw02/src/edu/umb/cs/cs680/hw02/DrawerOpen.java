/**
 * 
 */
package edu.umb.cs.cs680.hw02;

/**
 * @author avinashreddy
 *
 */
public class DrawerOpen implements State {
	private DrawerOpen() {}
	
	public static DrawerOpen instance = null;
	
	public static DrawerOpen getInstance() {
		if (instance == null) {
			instance = new DrawerOpen();
		}
		return instance;
	}
	@Override
	public void openCloseButtonPushed(DVDPlayer av) {
		
		boolean t = true;
		if (t == true) {
			av.close();
			
			av.changeState(DrawerClosedNotPlaying.getInstance());
		}		
		
	}
	@Override
	public void playButtonPushed(DVDPlayer av) {
		boolean t = true;
		if (t == true) {
			av.close();
			System.out.println("play");
			av.play();
			av.changeState(DrawerClosedPlaying.getInstance());
		}
		
	}
	
	@Override
	public void stopButtonPushed(DVDPlayer av) {
	}
}

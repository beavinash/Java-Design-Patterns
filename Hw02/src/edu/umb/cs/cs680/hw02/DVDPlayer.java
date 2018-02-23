/**
 * 
 */
package edu.umb.cs.cs680.hw02;

/**
 * @author avinashreddy
 *
 */
public class DVDPlayer {
	
	private DVDPlayer() {
		// Private Constructor
	};
	
	public static DVDPlayer instance = null;
	public static State st;
	
	public static DVDPlayer getInstance() {
		if (instance == null) {
			instance = new DVDPlayer();
			st= DrawerClosedNotPlaying.getInstance();
		}
		return instance;
	}
	
	public State changeState(State newstate) {
		st = newstate;
		return st;
	}
	
	public void openCloseButtonPushed() {
		//System.out.println("Open & Close Method Has Called");
		st.openCloseButtonPushed(this);
	}
	
	public void playButtonPushed() {
		//System.out.println("Play Button Method Has Called");
		st.playButtonPushed(this);
	}
	
	public void stopButtonPushed() {
		//System.out.println("Stop Button Method Has Called");
		st.stopButtonPushed(this);
	}
	
	public void open() {
		System.out.println("Opens the drawer");
		
		//return "Opens the drawer";
	}
	
	public void close() {
		System.out.println("Closes the drawer");
		
		//return "Closes the drawer";
	}
	
	public void play() {
		System.out.println("Play button has clicked");
		
		//return "Play button has clicked";
	}
	
	public void stop() {
		System.out.println("Stop button clicked");
		
		//return "Stop button clicked";
	}
	
	public static void main(String[] args) {
		DVDPlayer player = DVDPlayer.getInstance();
		player.changeState(st);
		st.openCloseButtonPushed(player);
		st.playButtonPushed(player);
		st.stopButtonPushed(player);
		
	}
}

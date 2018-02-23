/**
 * 
 */
package edu.umb.cs.cs680.hw02;

/**
 * @author avinashreddy
 *
 */
public class DVDPlayerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DVDPlayer av = DVDPlayer.getInstance();
		DrawerOpen dOpen = DrawerOpen.getInstance();
		DrawerClosedPlaying dCP = DrawerClosedPlaying.getInstance();
		DrawerClosedNotPlaying dCNP = DrawerClosedNotPlaying.getInstance();
		
		av.changeState(dOpen);
		av.changeState(dCP);
		
		av.changeState(null);
		av.changeState(dCNP);
	}

}

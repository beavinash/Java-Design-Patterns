/**
 * 
 */
package edu.umb.cs.cs680.hw02;

/**
 * @author avinashreddy
 *
 */
public interface State {
	
	// Interface Methods
	public default void openCloseButtonPushed(
				DVDPlayer av
			) {
		
	}
	
	public default void playButtonPushed(
				DVDPlayer av
			) {
		
	}
	
	public default void stopButtonPushed(
			DVDPlayer av
			) {
		
	}
}

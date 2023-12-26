package cryptoTrader.UIObserver;

/**
 * @author: Chun Yang, Micheal Wisdom Song
 * Description: we use Observer Design Pattern for rendering UI
 *              This is Observer interface class
 * */
public interface Observer { //allows for the update of the UI state
	
	/**
	 * Update the observer
	 * @param state is the subject the observer is attached to
	 * */
	public void update(UIState state);
}

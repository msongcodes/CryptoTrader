package cryptoTrader.UIObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Chun Yang, Michael Song
 * Description: We use Observer Design Pattern for rendering UI due to the fact that it allows for allows for the notification of state changes 
 *              This is Subject abstract class
 * */
public class UIState {
	
	/**
	 * observer store a list of observers for the subject
	 * */
	private List<Observer> observers = new ArrayList<Observer>();
	
	

	/**
	 * This method attach an observer to the subject
	 * @param observer is observer to be added
	 * */
	public void attach(Observer observer) { //adds an observer
		observers.add(observer);
	}
	
	/**
	 * This method detach an observer to the subject
	 * @param observer is observer to be detached
	 * */
	public void detach(Observer observer) { //removes an observer
		observers.remove(observer);
	}
	
	/**
	 * This method notify the observer when the subject state changed
	 * */
	public void notifyObservers() { //updates when a change has been made
		for(Observer observer : observers) {
			observer.update(this);
		}
	}
}

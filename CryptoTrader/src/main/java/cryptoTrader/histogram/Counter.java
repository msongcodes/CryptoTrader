package cryptoTrader.histogram;

/**
 * @author Chun Yang, Michael Song
 * Description: This is part of Histogram Item info to hold 
 *              the count of how many times each strategy is performed
 * */
public class Counter {
	
	/**
	 * strategyName store the name of Strategy this counter counts for
	 * count stores the count of the counter
	 */
	private String strategyName; 
	private int count;
	
	/**
	 * This is constructor to create a new counter
	 * @param strategyName is the name of strategy
	 */
	public Counter(String strategyName) {
		this.strategyName = strategyName; //initializes the local variables of the class
		this.count = 0;
	}
	
	/**
	 * This method increment count of the counter
	 */
	public void addCount() { //counts the amount of times a strategy is used
		this.count++;
	}
	
	/**
	 * This is getter method for the name of the strategy that the counter is used for
	 * @return the name of the strategy that the counter is used for
	 */
	public String getName() { //gives the name of the strategy
		return this.strategyName;
	}
	
	/**
	 * This is getter method for the count of the counter
	 * @return the count of the counter
	 */
	public int getCount() { //returns the count for a strategy
		return this.count;
	}
}

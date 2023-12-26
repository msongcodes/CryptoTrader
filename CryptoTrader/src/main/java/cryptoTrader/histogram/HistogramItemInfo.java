package cryptoTrader.histogram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chun Yang, Michael Song
 * Description: This is single Histogram item and it consists of trader name and strategy
 * */

public class HistogramItemInfo {
	
	/**
	 * traderName name of the broker
	 * countList list of counters
	 */
	private String traderName; //local variables
	private List<Counter> countList;
	
	/**
	 * Constructor
	 * @param name is the name of broker to be stored in traderName
	 */
	public HistogramItemInfo(String name) {
		this.traderName = name; //initializes local variables
		// for each trader, we should have 5 counter to count number of perform for each strategy
		this.countList = new ArrayList<Counter>();
		Counter strategyA = new Counter("Strategy-A"); //creates counters to keep tracck of how many times each strategy is used
		Counter strategyB = new Counter("Strategy-B");
		Counter strategyC = new Counter("Strategy-C");
		Counter strategyD = new Counter("Strategy-D");
		Counter strategyE = new Counter("Strategy-E");
		countList.add(strategyA); //adds a counter to the list
		countList.add(strategyB);
		countList.add(strategyC);
		countList.add(strategyD);
		countList.add(strategyE);
	}
	
	/**
	 * Getter methods to get traderName
	 * @return the name of broker
	 */
	public String getTraderName() { //returns the trader name
		return traderName;
	}
	
	/**
	 * Getter methods to get count list
	 * @return the list of counters
	 */
	public List<Counter> getCountList(){ //returns the list of counters for each strategy
		return countList;
	}
	
	/**
	 * Increment the count of a specific strategy
	 * @param strategyName the name of strategy of the counter to be incremented
	 */
	public void incrementCounter(String strategyName) { //increments the counter of a certain strategy
		for(Counter item : countList) {
			if(item.getName().equals(strategyName))
				item.addCount();
		}
	}
}
